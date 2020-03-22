package com.fairit.recipe_browser.model.randomSearchRecipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WinePairing {

    @ElementCollection
    @CollectionTable(name = "pairedWines")
    public List<String> pairedWines ;

    @Id
    public String pairingText;

    @ElementCollection
    @CollectionTable(name = "productMatches")
    public List<ProductMatch> productMatches;
}
