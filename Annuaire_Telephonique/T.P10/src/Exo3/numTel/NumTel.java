package Exo3.numTel;

public class NumTel
{
    private static final String FIXE_PROF = "FP";
    private static final String NUM_PORTABLE = "NP";
    private static final String FIXE_DOM = "FD";
    private static final String NUM_FAX = "NF";

    private int num;
    private String code;

    /**
     * Représente un numéro de téléphone
     * @param num
     * @param code
     */
    public NumTel(int num, String code)
    {
        this.num = num;
        this.code = code;
    }

    /**
     * Numéro de téléphone sous forme textuelle
     * @return chaine de caractères représentant le numéro de téléphone
     */
    @Override
    public String toString()
    {
        String chaine = "\n\t Numéro --> " + this.num;
        switch (this.code) {
            case "FP":
                chaine += " de nature [FIXE PROFESSIONNEL]";
                break;
            case "NP":
                chaine += " de nature [NUMÉRO PORTABLE]";
                break;
            case "FD":
                chaine += " de nature [FIXE DOMICILE]";
                break;
            case "NF":
                chaine += " de nature [NUMÉRO FAXE]";
                break;
        }
        return chaine;
    }

    /**
     * Récupère le numéro de téléphone
     * @return
     */
    public int getNum()
    {
        return this.num;
    }

    /**
     * Récupère le code représentant la nature du numéro
     * @return
     */
    public String getCode()
    {
        return this.code;
    }
}
