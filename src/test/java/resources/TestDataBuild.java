package resources;

import pojo.googlePlaceApiPojo.AddPlaceApi;
import pojo.googlePlaceApiPojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {
    public AddPlaceApi addPlacePayload(String name, String language, String address) {
        AddPlaceApi addPlace = new AddPlaceApi();
        addPlace.setAccuracy(50);
        addPlace.setName(name);
        addPlace.setPhone_number("(+91) 983 893 3937");
        addPlace.setAddress(address);
        addPlace.setWebsite("http://google.com");
        addPlace.setLanguage(language);

        List<String> types = new ArrayList<>();
        types.add("shoe park");
        types.add("shop");
        addPlace.setTypes(types);

        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        addPlace.setLocation(location);
        return addPlace;
    }
}
