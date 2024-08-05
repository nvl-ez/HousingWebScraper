package com.mycompany.uibscraper;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import java.util.TreeMap;

public class GestorAlojamientos {

    private static final String FILE_NAME = "persons.ser";

    public static void guardarAlojamientos(TreeMap<String, Alojamiento> alojamientos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            File file = new File(FILE_NAME);
            file.delete();
            file.createNewFile();
            for (Map.Entry<String, Alojamiento> alojamiento : alojamientos.entrySet()) {
                oos.writeObject(alojamiento.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TreeMap<String, Alojamiento> cargarAlojamientos() {
        TreeMap<String, Alojamiento> alojamientos = new TreeMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Alojamiento alojamiento = (Alojamiento) ois.readObject();
            while (alojamiento != null) {
                alojamientos.put(alojamiento.getTelefono(), alojamiento);
                alojamiento = (Alojamiento) ois.readObject();
            }
        } catch (EOFException e){
            return alojamientos;
        } catch(InvalidClassException e){
            File file = new File(FILE_NAME);
            file.delete();
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return alojamientos;
    }

    public static TreeMap<String, Alojamiento> merge(TreeMap<String, Alojamiento> alojamientos, LinkedList<Alojamiento> nuevos) {
        for (Alojamiento nuevo : nuevos) {
            if (!alojamientos.containsKey(nuevo.getTelefono())) {
                alojamientos.put(nuevo.getTelefono(), nuevo);
            } else{
                alojamientos.get(nuevo.getTelefono()).setNuevo(false);
            }
        }
        return alojamientos;
    }

    public static String listAll(TreeMap<String, Alojamiento> alojamientos) {
        String text = "";
        for (Map.Entry<String, Alojamiento> alojamiento : alojamientos.entrySet()) {
            text += alojamiento.getValue().toString() + "\n";
        }
        return text;
    }
}
