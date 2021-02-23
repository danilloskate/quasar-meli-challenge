package com.meli.quasar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.quasar.dto.QuasarResult;
import com.meli.quasar.dto.Satellite;
import com.meli.quasar.dto.TopSecretRequest;
import com.meli.quasar.entity.Satellites;
import com.meli.quasar.exception.QuasarException;
import com.meli.quasar.repository.SatellitesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuasarService {

	@Autowired
	LocationService locationService;

	@Autowired
	MessagesService messagesService;

	@Autowired
	SatellitesRepository satellitesRepository;

	public QuasarResult topSecret(TopSecretRequest request) throws QuasarException {
		QuasarResult result = new QuasarResult();

		result.setPosition(locationService.calculatePosition(request));
		result.setMessage(messagesService.getMessage(request.getMessages()));
		return result;

	}

	public Satellite topSecretSplitPost(Satellite request, String satelliteName) throws QuasarException {
		Optional<Satellites> satellitesOptional = satellitesRepository.findById(satelliteName);
		if (satellitesOptional.isPresent()) {
			Satellites satellites = satellitesOptional.get();
			satellites.setDistance(request.getDistance());
			satellites.setMessage(String.join(",", request.getMessage()));
			satellitesRepository.save(satellites);
			return new Satellite(satellites);
		} else {
			throw new QuasarException("No se pudo procesar la información");
		}
	}

	public QuasarResult topSecretSplit() throws QuasarException {
		List<Satellites> satellitesList = satellitesRepository.findAll();
		List<Satellite> satelliteList = new ArrayList<>();
		satellitesList.forEach(satellites -> satelliteList.add(new Satellite(satellites)));

		return topSecret(new TopSecretRequest(satelliteList));
	}
}
