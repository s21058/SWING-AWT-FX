import java.awt.*;
import java.util.Random;

public enum BallonColor  {
        Absolute_Zero, Midnight_Green, Cadmium_yellow, Dark_purple,
        Electric_violet, Up_Maroon, Linkoln_Green, Hot_magenta,
        Iceberg, Jazzberry_jam, Sandy_Brown, Electric_Ultramarine,
        Glitter, Navy_blue, Orange_peel, Smoky_black;
        public static Color setNewColor(BallonColor color) {
                Color c ;
                switch (color) {
                        case Absolute_Zero:
                                c = new Color(0x0048BA);
                                break;
                        case Midnight_Green:
                                c=new Color(0x004B57);
                                break;
                        case Cadmium_yellow:
                                c=new Color(0xFFF600);
                                break;
                        case Dark_purple:
                                c=new Color(0x301934);
                                break;
                        case Electric_violet:
                                c=new Color(0x8F00FF);
                                break;
                        case Up_Maroon:
                                c=new Color(0x760D0D);
                                break;
                        case Linkoln_Green:
                                c=new Color(0x176E11);
                                break;
                        case Hot_magenta:
                                c=new Color(0xFF1DCE);
                                break;
                        case Iceberg:
                                c=new Color(0x71A6D2);
                                break;
                        case Jazzberry_jam:
                                c=new Color(0xA50B5E);
                                break;
                        case Sandy_Brown:
                                c=new Color(0xF39C63);
                                break;
                        case Electric_Ultramarine:
                                c=new Color(0xD14C09);
                                break;
                        case Navy_blue:
                                c=new Color(0x000080);
                                break;
                        case Glitter:
                                c=new Color(0xD5F0F3);
                                break;
                        case Orange_peel:
                                c=new Color(0xFF9F00);
                                break;
                        case Smoky_black:
                                c=new Color(0x100C08);
                                break;
                        default:
                                throw new IllegalStateException("Unexpected value: " + color);
                }
                return c;
        }
        public static BallonColor getRandom_Color(){
                Random random =new Random();
                return (values()[random.nextInt(values().length)]);
        }
}