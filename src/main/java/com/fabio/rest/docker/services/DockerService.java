package com.fabio.rest.docker.services;



import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.ListContainersCmd;
import com.github.dockerjava.api.model.AuthConfig;
import com.github.dockerjava.api.model.AuthConfigurations;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.RemoteApiVersion;
import com.github.dockerjava.core.SSLConfig;


@Service
public class DockerService {

	public String getIdContainer() {
		DockerClient client = DockerClientBuilder.getInstance().build();
		//prepare command to retrieve the list of (running) containers 
		ListContainersCmd listContainersCmd = client.listContainersCmd().withShowAll(true);
		//and set the generic filter regarding name
		//listContainersCmd.getFilters().put("name", Arrays.asList("redis"));
		//finally, run the command
		List<Container> exec = listContainersCmd.exec();
		String idContainer=null;
		if(CollectionUtils.isEmpty(exec)) {
			System.out.println("Lista container vuota");
		}else {
			for(Container p:exec) {
				String nomeContainer=p.getNames()[0].replace("/", "");
				System.out.println(nomeContainer);
				if(nomeContainer.equals("app-docker-test-container")) {
					System.out.println(String.format("id:%s name:%s",p.getId(),p.getNames()[0]));
					idContainer=nomeContainer;
					break;
				}
			}
				

		}
		return idContainer;
	}
	
}
