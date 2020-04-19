package com.fairit.recipe_browser.model.random.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class WinePairing {

    public List<String> pairedWines;
    public String pairingText;
    public List<ProductMatch> productMatches;
}
