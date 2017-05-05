package com.example.zita.lab3.repository;

import android.content.Context;

import com.example.zita.lab3.model.Plant;

import java.util.ArrayList;
import java.util.List;

public class MemoryRepository implements Repository {
    private List<Plant> plants;

    @Override
    public void open(Context context) {
        plants = new ArrayList<>();
        plants.add(
            new Plant(
                1L,
                "https://www.starkl.hu/img/eshop/thumbnails/102440_jpg_83473_406_488.jpg",
                "Aloe Vera",
                "Gyógyhatású növény",
                false,
                "https://www.starkl.hu/img/eshop/thumbnails/102440_jpg_83473_406_488.jpg",
                "Az Aloe vera az egyik legrégebbi gyógynövény a különféle külső és belső bajok gyógyítására. Enyhíti a fájdalmat, segíti a sebek, sérülések gyorsabb gyógyulását. Vágjon le egy darab levelet, majd a kipréselt levet kenje a sebre! A vaskos levelekből koktélok, italok is készülhetnek.",
                "Márciustól májusig és szeptembertől novemberig.",
                "Márciustól májusig és szeptembertől novemberig."
            )
        );
        plants.add(
            new Plant(
                2L,
                "https://www.starkl.hu/img/eshop/thumbnails/131955_jpg_103626_406_488.jpg",
                "Bugás hortenzia Phantom",
                "Díszcserje / Díszfa",
                true,
                "https://www.starkl.hu/img/eshop/thumbnails/131955_jpg_103626_406_488.jpg",
                "Fantasztikus, rendkívül hosszú ideig tartó virágpompa. Az elvirágzásig a világító fehértől a sötétpirosig csodálhatja színeit.",
                "Márciustól júniusig és szeptembertől októberig.",
                "Júliustól októberig."
            )
        );

    }

    @Override
    public void close() {

    }

    @Override
    public List<Plant> getPlants() {
        return plants;
    }

    @Override
    public Plant getPlant(Long plantId) {
        return plants.get(plantId.intValue()-1);
    }

    @Override
    public Plant toggleFavouriteStatus(Long plantId) {
        Plant plant = plants.get(plantId.intValue()-1);
        plant.setFavourite(plant.isFavourite() ? false : true);
        return plant;
    }
}
