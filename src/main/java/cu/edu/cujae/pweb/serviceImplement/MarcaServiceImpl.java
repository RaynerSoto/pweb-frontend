package cu.edu.cujae.pweb.serviceImplement;

import cu.edu.cujae.pweb.dto.MarcaDto;
import cu.edu.cujae.pweb.service.MarcaService;
import cu.edu.cujae.pweb.util.ResponseReciboUtil;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private RestService restService;

    @Override
    public ResponseReciboUtil inserta_marca(MarcaDto marcaDto) throws Exception {
        ResponseReciboUtil responseReciboUtil = new ResponseReciboUtil();
        ApiRestMapper<ResponseReciboUtil> apiRestMapper = new ApiRestMapper<>();
        String respuesta = (String) restService.POST("/api/v1/marcas/",marcaDto,String.class).getBody();
        responseReciboUtil = apiRestMapper.mapOne(respuesta, ResponseReciboUtil.class);
        return responseReciboUtil;
    }

    @Override
    public ResponseReciboUtil modificar_marca(MarcaDto marcaDto) throws Exception {
        return null;
    }

    @Override
    public ResponseReciboUtil eliminar_marca(Long id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<MarcaDto> listado_marcas() throws Exception {
        return null;
    }

    @Override
    public MarcaDto obtener_marca(long id) throws Exception {
        return null;
    }
}
