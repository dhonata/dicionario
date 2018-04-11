package br.estacio.prii.dicionario.entidade;


import java.util.ArrayList;

public class Dicionario
{
    private ArrayList<Palavra> palavras;

    //Construtores    
    public Dicionario() 
    {
        palavras = new ArrayList<>();
    }
    
    public Dicionario(ArrayList<Palavra> palavras) 
    {
        this.palavras = palavras;
    }
    
    //Métodos da Classe: Dicionário
    public void adicionar(String portugues, String ingles)
    {
        palavras.add(new Palavra(portugues, ingles));
        removerDuplicados();
    }
    
    public void remover(String palavra)
    {
        for(int i = 0; i < palavras.size(); i++) {
            if((palavras.get(i).getIngles() + " - " + palavras.get(i).getPortugues()).equals(palavra)) {
                palavras.remove(i);
                i--;
            }
        }
    }
    
    public Palavra pesquisar(String palavra)
    {
        for(Palavra p : palavras) {
            if(p.getIngles().equals(palavra) || p.getPortugues().equals(palavra)) {
                return p;
            }
        }
        
        return null;
    }
    
    // Métodos Acessore e Modificadores
    public void setPalavras(ArrayList<Palavra> palavras)
    {
        this.palavras = palavras;
    }
    
    public ArrayList<Palavra> getPalavras() 
    {
        return palavras;
    }
    
    // Método Privado da Classe: Dicionário
    private void removerDuplicados() 
    {
        for (int i = 0; i < palavras.size(); i++) {
            Palavra a = palavras.get(i);
            for (int j = i + 1; j < palavras.size(); j++) {
                Palavra b = palavras.get(j);
                if (a.getIngles().equals(b.getIngles()) || a.getPortugues().equals(b.getPortugues())) {
                    palavras.remove(j);
                    j--;
                }
            }
        }
    }
}
