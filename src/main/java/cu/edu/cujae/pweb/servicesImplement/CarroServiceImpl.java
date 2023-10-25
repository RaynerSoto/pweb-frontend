package cu.edu.cujae.pweb.servicesImplement;

import cu.edu.cujae.pweb.dto.CarroDto;
import cu.edu.cujae.pweb.service.CarroService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
<<<<<<< HEAD
=======

import org.springframework.stereotype.Service;

>>>>>>> f642fa0cd227bc70502dad120c02e0888a55f7b4
@Service
public class CarroServiceImpl implements CarroService {
    @Override
    public void insertar_datos(CarroDto car) {

    }

    @Override
    public void modificar_datos(CarroDto car, long id) {

    }

    @Override
    public void eliminar_datos(long id) {

    }

    @Override
    public ArrayList<CarroDto> listado_carros() {
        return null;
    }
}
