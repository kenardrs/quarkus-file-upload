package org.acme.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.acme.entity.FormData;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class UploadService {
    @ConfigProperty(name = "quarkus.http.body.uploads.directory")
    String directory;

    public String sendFile(FormData data) throws IOException {
        List<String> mimetype = Arrays.asList("image/jpg", "image/jpeg", "image/gif", "image/png", "application/pdf");

        if(!mimetype.contains(data.getFile().contentType())){
            throw new IOException("Formato de imagem não suportado");
        }

        if(data.getFile().size() > 1024 * 1024 * 4) {
            throw new IOException("Imagem maior do que o tamanho permitido");
        }


        return "Arquivo " + data.getFile().name() + " enviado com sucesso. Tamanho = " + data.getFile().size();
    }
}
