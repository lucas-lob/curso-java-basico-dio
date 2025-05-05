public class iPhone implements MusicalReprodutor, InternetNavegator, Phone {

    private String musicSelected = "";
    private boolean musicPaused = false;
    private boolean musicPlayed = false;
    private boolean inCall = false;
    private int internetTabAmount = 0;

    @Override
    public void selectMusic(String music) {
        musicSelected = music;
        System.out.println("Selecionando a música " + music);
    }

    @Override
    public void playMusic() {
        if (!musicSelected.equals("")) {
            musicPlayed = true;
            musicPaused = false;
            System.out.println("Tocando a música " + this.musicSelected);
        } else {
            System.out.println("Você precisa selecionar ao menos uma música!");
        }
    }

    @Override
    public void pauseMusic() {
        if (musicPlayed) {
            musicPlayed = false;
            musicPaused = true;
            System.out.println("Música " + this.musicSelected + " pausada!");
        } else {
            System.out.println("Você precisa selecionar ao menos uma música!");
        }
    }

    @Override
    public void newTab() {
        if (internetTabAmount == 0) {
            internetTabAmount++;
            System.out.println("Nova aba aberta!");
        } else {
            System.out.println("Já existe uma aba aberta!");
        }
    }

    @Override
    public void showPage(String url) {
        if (internetTabAmount > 0) {
            System.out.println("Página com URL: " + url + " carregada!");
        } else {
            System.out.println("Não existe nenhuma aba aberta!");
        }
    }

    @Override
    public void updatePage() {
        if (internetTabAmount > 0) {
            System.out.println("Página atualizada!");
        } else {
            System.out.println("Não existe nenhuma aba aberta!");
        }
    }

    @Override
    public void turnOn(String number) {
        if (!inCall) {
            System.out.println("Ligando para " + number);
        } else {
            System.out.println("Já está em chamada!");
        }
    }

    @Override
    public void toResponde() {
        System.out.println("Atendendo!");
        inCall = true;
    }

    @Override
    public void voiceMail() {
        System.out.println("Ouvindo o correio de voz!");
        inCall = true;
    }
}
