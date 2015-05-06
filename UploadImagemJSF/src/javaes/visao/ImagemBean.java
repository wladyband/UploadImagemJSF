package javaes.visao;

import java.io.IOException;
import javaes.controle.ImagemRN;
import javaes.modelo.Imagem;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
/**
*
* @author javaES
*/
@ManagedBean
@RequestScoped
public class ImagemBean
{
    public ImagemBean() 
    {
    }
    public void fileUpload(FileUploadEvent event) throws IOException 
    {
        try
        {
            //Instância objetos
            ImagemRN imagemRN                   = new ImagemRN();
            Imagem im                           = new Imagem();
           
            //Cria um arquivo UploadFile, para receber o arquivo do evento
            UploadedFile arq                                = event.getFile();
            //Transformar a imagem em bytes para salvar em banco de dados
            byte[] bimagem                                  = event.getFile().getContents();
            im.setImagem(bimagem);
            im.setNomeArquivo(arq.getFileName());
            imagemRN.salvar(im);
           
            //Essa parte comentada deve ser usada caso queira salvar
            //o arquivo em um local fisuco do servidor.
            /*
            InputStream in                                  = new BufferedInputStream(arq.getInputstream()); 
            File file                                       = new File("C://var//" + arq.getFileName());
            //O método file.getAbsolutePath() fornece o caminho do arquivo criado
            //Pode ser usado para ligar algum objeto do banco ao arquivo enviado
            String caminho                                  = file.getAbsolutePath();
            FileOutputStream fout = new FileOutputStream(file);
        while(in.available() != 0)
        {
            fout.write(in.read());
        }
        fout.close();*/
        FacesMessage msg                                                        = new FacesMessage("O Arquivo ", arq.getFileName() + " salvo em banco de dados.");
        FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
