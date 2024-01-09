package cu.edu.cujae.pweb.config;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

import javax.servlet.ServletContext;
@RewriteConfiguration
public class UrlRewriteConfigurationProvider extends HttpConfigurationProvider {

    @Override
    public Configuration getConfiguration(ServletContext servletContext) {
        return ConfigurationBuilder.begin()
                .addRule(Join.path("/Carros").to("/pages/Carro/carro_list.jsf"))
                .addRule(Join.path("/Hoja_de_Ruta").to("/pages/hojaderuta/hojaderuta_list.jsf"))
                .addRule(Join.path("/Marcas").to("//pages/marca/marca_list.jsf"))
                .addRule(Join.path("/Combustibles").to("/pages/combustible/combustible_list.jsf"))
                .addRule(Join.path("/Usuarios").to("/pages/usuario/user-list.jsf"));

    }

    @Override
    public int priority() {
        return 0;
    }
}
