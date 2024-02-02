package fr.hermancia.poec.hermanciagames.json_views;

public class JsonViews {



    public interface GameView
            extends
            GameSimpleView {}


    public interface CountryDetailView {}

    public interface UserMinimalView {}
    public interface UserListView
            extends
            UserMinimalView,
            CountryDetailView {}

    public interface UserProfileView
            extends
            CountryDetailView,
            GameListShowView,
            UserMinimalView,
            ReviewShowView {}

    public interface CategoryMinimalView {}

    public interface CategoryView
            extends
            CategoryMinimalView{}

    public interface GameSimpleView {}


    public interface PlatformView
            extends
            PlatformSimpleView{}
    public interface PlatformSimpleView {}

    public interface GameListShowView
            extends
            GameSimpleView,
            EconomicModelView,
            PegiShowView,
            PublisherShowView,
            UserListView,
            ReviewShowView,
            PlatformSimpleView,
            CategoryMinimalView,
            CountryDetailView {}


    public interface ReviewShowView
        extends
        GameView, UserListView{}


    public interface PublisherShowView
            extends
            CountryDetailView {}

    public interface PublisherAllView
            extends
            PublisherShowView,
            GameListShowView {}


    public interface EconomicModelView {}

    public interface PegiShowView{}

    public interface ReviewView {}
    public interface ReviewAllView
            extends
            GameSimpleView,
            UserMinimalView,
            ReviewView,
            ReviewShowView,
            UserListView {}






}
