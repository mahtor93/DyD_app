package com.example.creacindepersonaje.Modelos;

import java.util.ArrayList;

public class Campaing {
    private String nameCampaing;
    private String descriptionCampaing;
    private ArrayList<Escena> sceneCampaing;


    public String getNameCampaing() {
        return nameCampaing;
    }

    public void setNameCampaing(String nameCampaing) {
        this.nameCampaing = nameCampaing;
    }

    public String getDescriptionCampaing() {
        return descriptionCampaing;
    }

    public void setDescriptionCampaing(String descriptionCampaing) {
        this.descriptionCampaing = descriptionCampaing;
    }

    public ArrayList<Escena> getSceneCampaing() {
        return sceneCampaing;
    }

    public void setSceneCampaing(ArrayList<Escena> sceneCampaing) {
        this.sceneCampaing = sceneCampaing;
    }

    public class Escena{
        private ArrayList<String> Objetivos;
        private String descripcionEscena;
        private Battle batalla;

        public Battle getBatalla() {
            return batalla;
        }

        public void setBatalla(Battle batalla) {
            this.batalla = batalla;
        }

        public ArrayList<String> getObjetivos() {
            return Objetivos;
        }

        public void setObjetivos(ArrayList<String> objetivos) {
            Objetivos = objetivos;
        }

        public String getDescripcionEscena() {
            return descripcionEscena;
        }

        public void setDescripcionEscena(String descripcionEscena) {
            this.descripcionEscena = descripcionEscena;
        }
    }
}
