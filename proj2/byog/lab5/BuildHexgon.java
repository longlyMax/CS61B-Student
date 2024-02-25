package byog.lab5;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import org.junit.Test;

import java.util.Random;

//import static byog.lab5.RandomWorldDemo.RANDOM;
import static org.junit.Assert.assertEquals;

//import java.lang.Object.Position;


/**
 * @author longlyMax
 * @version 1.0
 */
public class BuildHexgon {
    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    /**
     *
     * @param size 六边形的尺寸
     * @param rowNumber 行号，第0行为起始行
     * @return
     */
    public static int hexRowWidth(int size, int rowNumber) {
        int effectiveI = rowNumber;

        //对下半六边形的形状宽度获取
        if (rowNumber >= size) {
            effectiveI = 2 * size - 1 - effectiveI;
        }

        return size + 2 * effectiveI;
    }

    /**
     * 此方法用于求得相当于基准行而言，每一行起始坐标向左的偏移量
     * @param s 得到尺寸size
     * @param i 第几行 0行为基准行
     * @return 实际上就是每一行每一边变动的量
     */
    public static int hexRowOffset(int s, int i) {
        int effectiveI = i;
        if (i >= s) {
            effectiveI = 2 * s - 1 - effectiveI;
        }
        return -effectiveI;
    }

    /** Adds a row of the same tile.
     * @param world the world to draw on
     * @param p the leftmost position of the row
     * @param width the number of tiles wide to draw
     * @param t the tile to draw
     */
    public static void addRow(TETile[][] world, Position p, int width, TETile t) {
        for (int xi = 0; xi < width; xi += 1) {
            int xCoord = p.x + xi;
            int yCoord = p.y;
            world[xCoord][yCoord] = TETile.colorVariant(t, 32, 32, 32, RANDOM);
        }
    }

    /**
     * Adds a hexagon to the world.
     * @param world the world to draw on
     * @param p the bottom left coordinate of the hexagon，传入基准行的起始点
     * @param s the size of the hexagon
     * @param t the tile to draw，需要绘画的tile类型，鲜花，砖块或者空白
     */
    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {

        if (s < 2) {
            throw new IllegalArgumentException("Hexagon must be at least size 2.");
        }

        // hexagons have 2*s rows. this code iterates up from the bottom row,
        // which we call row 0.
        for (int yi = 0; yi < 2 * s; yi += 1) {
            int thisRowY = p.y + yi;//起始点的y坐标加上行号即为六边形左上角的点

            int xRowStart = p.x + hexRowOffset(s, yi);//得到每一行的起始x坐标
            Position rowStartP = new Position(xRowStart, thisRowY);

            int rowWidth = hexRowWidth(s, yi);//得到行宽度

            addRow(world, rowStartP, rowWidth, t);//添加行

        }
    }

    @Test
    public void testHexRowWidth() {
        assertEquals(3, hexRowWidth(3, 5));
        assertEquals(5, hexRowWidth(3, 4));
        assertEquals(7, hexRowWidth(3, 3));
        assertEquals(7, hexRowWidth(3, 2));
        assertEquals(5, hexRowWidth(3, 1));
        assertEquals(3, hexRowWidth(3, 0));
        assertEquals(2, hexRowWidth(2, 0));
        assertEquals(4, hexRowWidth(2, 1));
        assertEquals(4, hexRowWidth(2, 2));
        assertEquals(2, hexRowWidth(2, 3));
    }

    @Test
    public void testTile() {
        TETile[][] randomTiles = new TETile[50][50];//得到二维数组
        Position position = new Position(6, 6);
        addHexagon(randomTiles, position, 3, Tileset.FLOWER);
    }
}

