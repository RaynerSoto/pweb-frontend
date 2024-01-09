package cu.edu.cujae.pweb.util;

import cu.edu.cujae.pweb.dto.ChoferDto;

public class ResponseEnvioChofer {
    private ChoferDto choferDto;
    private String CI;

    public ResponseEnvioChofer() {
    }

    public ResponseEnvioChofer(ChoferDto choferDto, String CI) {
        this.choferDto = choferDto;
        this.CI = CI;
    }

    public ChoferDto getChoferDto() {
        return choferDto;
    }

    public void setChoferDto(ChoferDto choferDto) {
        this.choferDto = choferDto;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }
}
