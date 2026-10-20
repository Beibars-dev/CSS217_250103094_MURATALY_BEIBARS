interface DigitalGame {
    void playDigital();
}

class ModernGame implements DigitalGame {
    private final String title;

    public ModernGame(String title) {
        this.title = title;
    }

    @Override
    public void playDigital() {
        System.out.println("Streaming digital game: " + title);
    }
}

class ModernConsole {
    public void run(DigitalGame game) {
        System.out.println("[ModernConsole] Booting game...");
        game.playDigital();
    }
}

class RetroCartridge {
    private final String title;

    public RetroCartridge(String title) {
        this.title = title;
    }

    public void insertCartridge() {
        System.out.println("*click* Cartridge inserted. Playing retro game: " + title);
    }
}

class CartridgeAdapter implements DigitalGame {
    private final RetroCartridge cartridge;

    public CartridgeAdapter(RetroCartridge cartridge) {
        this.cartridge = cartridge;
    }

    @Override
    public void playDigital() {
        System.out.println("[CartridgeAdapter] Converting cartridge signal to digital...");
        cartridge.insertCartridge();
    }
}

public class RetroGamePlayer {
    public static void main(String[] args) {
        ModernConsole console = new ModernConsole();

        DigitalGame modern = new ModernGame("Space Odyssey 2077");
        DigitalGame retro  = new CartridgeAdapter(new RetroCartridge("Pixel Plumber 1985"));

        console.run(modern);
        System.out.println();
        console.run(retro);
    }
}
