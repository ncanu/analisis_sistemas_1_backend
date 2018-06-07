package com.example.registry.controllers;

import com.example.registry.models.Registry;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegistryResponse {

    @JsonProperty
    Registry registry;

    @JsonProperty
    String userName;
}
