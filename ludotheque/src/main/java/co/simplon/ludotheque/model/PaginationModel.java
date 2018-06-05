package co.simplon.ludotheque.model;

public class PaginationModel {
	
		private int boutonsAAfficher = 5;
	    private int premierePage;
	    private int dernierePage;
	    
	    public PaginationModel(int pagesTotales, int pageActuelle, int boutonsAAfficher) {
	        setBoutonsAAfficher(boutonsAAfficher);
	        int moitieDesPagesAAfficher = getBoutonsAAfficher() / 2;
	        if (pagesTotales <= getBoutonsAAfficher()) {
	            setPremierePage(1);
	            setDernierePage(pagesTotales);
	        } else if (pageActuelle - moitieDesPagesAAfficher <= 0) {
	        	setPremierePage(1);
	        	setDernierePage(getBoutonsAAfficher());
	        } else if (pageActuelle + moitieDesPagesAAfficher == pagesTotales) {
	        	setPremierePage(pageActuelle - moitieDesPagesAAfficher);
	        	setDernierePage(pagesTotales);
	        } else if (pageActuelle + moitieDesPagesAAfficher > pagesTotales) {
	        	setPremierePage(pagesTotales - getBoutonsAAfficher() + 1);
	        	setDernierePage(pagesTotales);
	        } else {
	        	setPremierePage(pageActuelle - moitieDesPagesAAfficher);
	        	setDernierePage(pageActuelle + moitieDesPagesAAfficher);
	        }
	    }
	    public int getBoutonsAAfficher() {
	        return boutonsAAfficher;
	    }
	    public void setBoutonsAAfficher(int boutonsAAfficher) {
	        if (boutonsAAfficher % 2 != 0) {
	            this.boutonsAAfficher = boutonsAAfficher;
	        } else {
	            throw new IllegalArgumentException("La valeur est impaire !");
	        }
	    }
	    public int getPremierePage() {
	        return premierePage;
	    }
	    public void setPremierePage(int premierePage) {
	        this.premierePage = premierePage;
	    }
	    public int getDernierePage() {
	        return dernierePage;
	    }
	    public void setDernierePage(int dernierePage) {
	        this.dernierePage = dernierePage;
	    }
	    @Override
	    public String toString() {
	        return "Pagination [premierePage=" + premierePage + ", dernierePage=" + dernierePage + "]";
	    }
	    
}
