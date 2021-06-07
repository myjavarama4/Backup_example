package pokus;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;

public final class Board extends javafx.scene.layout.Pane {

    private static final DoubleBinaryOperator addition = (a, b) -> a + b;
    private static final DoubleBinaryOperator subtraction = (a, b) -> a - b;
    private static final int HEIGHT_50 = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2);

    public Board(int text_size, int text_height, int text_width) {
        var width = Toolkit.getDefaultToolkit().getScreenSize().width;
        var height = Toolkit.getDefaultToolkit().getScreenSize().width;
        setCursor(new ImageCursor(new Image(getClass().getResourceAsStream("cursor.png"))));
        getChildren().addAll(new Clock("date", width - 325, 75), new Clock("time", width - 300, 25), new Clock("day", width - 75, 0));
        var horse = new ArrayList<Horse>() {
            {
                add(new Horse("FANTOME", 1200, 40, 1000, Color.ORANGE, 1));
                add(new Horse("GAVORA", 1200, 40, 1000, Color.ORANGE, 3));
                add(new Horse("LADY ANNE", 2000, 120, 1000, Color.BROWN, 6));
                add(new Horse("PASEK", 2000, 120, 1000, Color.BROWN, 8));
                add(new Horse("KORAN", 2400, 160, 1000, Color.BROWN, 9));
                add(new Horse("NEKLAN", 2800, 200, 2000, Color.LIGHTBLUE, 11));
                add(new Horse("PORTLANCL", 2800, 200, 2000, Color.LIGHTBLUE, 13));
                add(new Horse("JAPAN", 3200, 240, 2000, Color.LIGHTBLUE, 14));
                add(new Horse("KOSTRAVA", 3600, 280, 2000, Color.LIGHTGREEN, 16));
                add(new Horse("LUKAVA", 3600, 280, 2000, Color.LIGHTGREEN, 18));
                add(new Horse("MELAK", 4000, 320, 2000, Color.LIGHTGREEN, 19));
                add(new Horse("GRIFEL", 4400, 360, 3000, Color.MAGENTA, 21));
                add(new Horse("MOHYLA", 4400, 360, 3000, Color.MAGENTA, 23));
                add(new Horse("METAL", 4800, 400, 3000, Color.MAGENTA, 24));
                add(new Horse("TARA", 5200, 440, 3000, Color.YELLOW, 26));
                add(new Horse("FURIOSO", 5200, 440, 3000, Color.YELLOW, 27));
                add(new Horse("GENIUS", 5600, 480, 3000, Color.YELLOW, 29));
                add(new Horse("SHAGGA", 6000, 520, 4000, Color.DARKGREEN, 31));
                add(new Horse("DAHOMAN", 6000, 520, 4000, Color.DARKGREEN, 32));
                add(new Horse("GIRA", 6400, 560, 4000, Color.DARKGREEN, 34));
                add(new Horse("NARCIUS", 6800, 100, 4000, Color.PURPLE, 37));
                add(new Horse("NAPOLI", 100, 100, 4000, Color.PURPLE, 39));
            }
        };
        var paths = Board.draw(0.5, 0.2, 0.3, 0.12, Path_carts::new);
        var paths2 = Board.draw(0.3, 0.12, 0.2, 0.08, Path_roads::new);
        //    getChildren().add(new Line(550, 0, 550, height * 0.2));
        //     var first = paths.get(0);
        //     var ff = (LineTo) first.getElements().get(1);
        //     var ff2 = (LineTo) first.getElements().get(1);
        //   var point = new Point2D(first.get
        //       first.setFill(Color.RED);
        //     var firstarc = new Path(new MoveTo(((LineTo) first.getElements().get(1)).getX(), ((LineTo) first.getElements().get(1)).getY()), (ArcTo) first.getElements().get(2));
        //     var firstarc2 = new Path(new MoveTo(((LineTo) first.getElements().get(3)).getX(), ((LineTo) first.getElements().get(3)).getY()), (ArcTo) first.getElements().get(4));

        // getChildren().add(group);
        //      write_word(paths);
        //  paths.get(0).setFill(Color.RED);
        /*   horse.forEach((t) -> {
            var index = horse.indexOf(t);
            switch (index % 3) {
                case 0 -> {
                    t.husband.add(horse.get(index + 1));
                    t.husband.add(horse.get(index + 2));
                }
                case 2 -> {
                    t.husband.add(horse.get(index - 1));
                    t.husband.add(horse.get(index - 2));
                }
                default -> {
                    t.husband.add(horse.get(index - 1));
                    t.husband.add(horse.get(index + 1));
                }
            }
        });*/
        //  paths.get(0).setFill(Color.ORANGE);
        getChildren().addAll(paths);
        paths.get(0).setFill(Color.RED);
        getChildren().addAll(paths2);
        Cart cart = new Cart(height * 0.2, height * 0.2, 40, 100);
        cart.getChildren().addAll(horse.get(0).getAllFields());
        Cart_background cartt = new Cart_background();
        getChildren().add(cart);
        getChildren().add(cartt);
        /*    horse.forEach((t) -> {
            paths.get(t.array_number).setFill(t.getColor());
            t.array_number = null;
        });*/

        paths.get(1).setFill(horse.get(0).getColor());
        paths.get(3).setFill(horse.get(1).getColor());
        paths.get(6).setFill(horse.get(2).getColor());
        paths.get(8).setFill(horse.get(3).getColor());
        paths.get(9).setFill(horse.get(4).getColor());
        paths.get(11).setFill(horse.get(5).getColor());
        paths.get(13).setFill(horse.get(6).getColor());
        paths.get(14).setFill(horse.get(7).getColor());
        paths.get(16).setFill(horse.get(8).getColor());
        paths.get(18).setFill(horse.get(9).getColor());
        paths.get(19).setFill(horse.get(10).getColor());
        paths.get(21).setFill(horse.get(11).getColor());
        paths.get(23).setFill(horse.get(12).getColor());
        paths.get(24).setFill(horse.get(13).getColor());
        paths.get(26).setFill(horse.get(14).getColor());
        paths.get(28).setFill(horse.get(15).getColor());
        paths.get(29).setFill(horse.get(16).getColor());
        paths.get(31).setFill(horse.get(17).getColor());
        paths.get(33).setFill(horse.get(18).getColor());
        paths.get(34).setFill(horse.get(19).getColor());
        paths.get(37).setFill(horse.get(20).getColor());
        paths.get(39).setFill(horse.get(21).getColor());
        //    paths2.get(1).setHorse(horse.get(0), cartt, cart);
        //     paths2.get(3).setHorse(horse.get(1), cartt, cart);
        //     getChildren().add(text(paths));
        /* getChildren().add(*/
        text(paths, text_size, text_height, text_width);

        var text = new Text("O");
        text.setBoundsType(TextBoundsType.VISUAL);
        //text.setTextOrigin(VPos.CENTER);
        //   text.setTextAlignment(TextAlignment.LEFT);
        text.setFont(Font.font(50));

        //   text.setLayoutX(0);
        //   text.setLayoutY(100);
        //     text.setX(0);
        //  text.setY(0);
        var pane = new HBox(text);
        pane.setStyle("-fx-background-color: green");
        pane.setLayoutX(100);
        pane.setLayoutY(100);
        System.out.println(pane.getWidth());
        System.out.println(pane.getHeight());
        System.out.println();

        getChildren().add(pane);
        getChildren().add(new Line(100, 0, 100, 100));

    }

    private Line line_of_arc(Path_carts path) {
        var line = new ArrayList<Double>();
        for (var i = 1; i <= 3; i += 2) {
            var radius = ((ArcTo) path.getElements().get(i + 1)).getRadiusX();
            var pp = ((LineTo) path.getElements().get(i)).getX();
            var pp2 = ((ArcTo) path.getElements().get(i + 1)).getX();
            var pp3 = ((LineTo) path.getElements().get(i)).getY();
            var pp4 = ((ArcTo) path.getElements().get(i + 1)).getY();
            if (pp > pp2) {
                pp = pp2;
            }
            if (pp3 > pp4) {
                pp3 = pp4;
            }
            var ix = pp + Math.abs(((LineTo) path.getElements().get(i)).getX() - ((ArcTo) path.getElements().get(i + 1)).getX()) / 2;
            var iy = pp3 + Math.abs(((LineTo) path.getElements().get(i)).getY() - ((ArcTo) path.getElements().get(i + 1)).getY()) / 2;
            var u1x = ix - HEIGHT_50;
            var u1y = iy - HEIGHT_50;
            var cc = Math.sqrt(u1x * u1x + u1y * u1y);
            line.add(HEIGHT_50 + u1x / cc * radius);
            line.add(HEIGHT_50 + u1y / cc * radius);
        }
        if (line.get(0) > HEIGHT_50) {
            return new Line(line.get(2), line.get(3), line.get(0), line.get(1));
        } else {
            return new Line(line.get(0), line.get(1), line.get(2), line.get(3));
        }
    }

    private Line line_of_line(Path_carts path) {
        double x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        var lineTo1 = (LineTo) path.getElements().get(1);
        var lineTo2 = (LineTo) path.getElements().get(2);
        var lineTo3 = (LineTo) path.getElements().get(3);
        var lineTo4 = (LineTo) path.getElements().get(4);
        if (lineTo1.getY() == lineTo2.getY()) {
            y1 = lineTo3.getY();
            y2 = lineTo1.getY();
            x1 = lineTo4.getX() + (lineTo3.getX() - lineTo4.getX()) / 2;
            x2 = lineTo1.getX() + (lineTo2.getX() - lineTo1.getX()) / 2;
        }
        if (lineTo1.getX() == lineTo2.getX()) {
            x1 = lineTo3.getX();
            x2 = lineTo1.getX();
            y1 = lineTo4.getY() + (lineTo3.getY() - lineTo4.getY()) / 2;
            y2 = lineTo1.getY() + (lineTo2.getY() - lineTo1.getY()) / 2;
        }
        if (x2 == 0 || y2 == 0) {
            return new Line(x2, y2, x1, y1);
        } else {
            return new Line(x1, y1, x2, y2);
        }
    }

    private void text(ArrayList<Path_carts> paths, int text_size, int text_height, int text_width) {
        var cards = new ArrayList<String>() {
            {
                add("START");
                add("FANTOME");
                add("FINANCE");
                add("GAVORA");

                add("VYŠETŘENÍ");
                add("TRENÉR");
                add("LADY ANNE");
                add("NÁHODA");
                add("PASEK");
                add("KORAN");

                add("DISTANC");
                add("NEKLAN");
                add("PŘEPRAVA");
                add("PORTLANCL");
                add("JAPAN");

                add("TRENÉR");
                add("KOSTRAVA");
                add("FINANCE");
                add("LUKAVA");
                add("MELAK");

                add("PARKOVIŠTĚ");
                add("GRIFEL");
                add("NÁHODA");
                add("MOHYLA");
                add("METAL");

                add("TRENÉR");
                add("TARA");
                add("FURIOSO");
                add("STÁJE");
                add("GENIUS");

                add("DOPING");
                add("SHAGGA");
                add("DAHOMAN");
                add("FINANCE");
                add("GIRA");

                add("TRENÉR");
                add("NÁHODA");
                add("NARCIUS");
                add("VYŠETŘENÍ");
                add("NAPOLI");
            }
        };

        var path = paths.get(30);
        var height20 = (int) (HEIGHT_50 * 0.4);
        for (var i = 0; i < 40; i += 1) {
            double x1 = 0, x2 = 0, y1 = 0, y2 = 0;
            if (paths.get(i).getElements().get(2) instanceof LineTo) {
                var line = line_of_line(paths.get(i));
                getChildren().add(line);
                //        System.out.println(line);
                var points = getPoints(line, cards.get(i).length(), text_size);

                //          var circle = new Circle(line.getStartX() - (line.getStartX() - line.getEndX()) / 2, line.getStartY() - (line.getStartY() - line.getEndY()) / 2, 3, Color.BLUEVIOLET);
                //     getChildren().add(circle);
                /*            var text = new Text("X");

                text.setFont(Font.loadFont(getClass().getResourceAsStream("GT Pressura Mono Regular Regular.ttf"), size));
                text.setLayoutX(circle.getCenterX() - (size / 4));
                text.setLayoutY(circle.getCenterY());
                text.setBoundsType(TextBoundsType.VISUAL);
                text.setTextOrigin(VPos.CENTER);
                text.setTextAlignment(TextAlignment.CENTER);
                text.setFill(Color.BLUE);
                getChildren().add(text);
                text = new Text("O");

                text.setFont(Font.loadFont(getClass().getResourceAsStream("GT Pressura Mono Regular Regular.ttf"), size));
                text.setLayoutX(circle.getCenterX() - (size / 4));
                text.setLayoutY(circle.getCenterY() - 50);
                getChildren().add(text);
                getChildren().add(middle_of_line(path));
                getChildren().add(circle);*/
            } else {
                var line = line_of_arc(paths.get(i));
                getChildren().add(line);
                var points = getPoints(line, cards.get(i).length(), text_size);
                //     var points = getPoints(line, cards.get(i).length(), text_height, text_width, false);
                //     var big_arc = midpoint_of_arc(t, 1);
                //    var small_arc = midpoint_of_arc(t, 3);

                //   getChildren().add(new Circle(small_arc[0] - (small_arc[0] - big_arc[0]) / 2, small_arc[1] - (small_arc[1] - big_arc[1]) / 2, 5, Color.BLUEVIOLET));
            }
        }

        var pane = new Pane();
        var scene = new Scene(pane);
        var gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setLayoutX(((MoveTo) path.getElements().get(0)).getX() - 100);
        gridPane.setLayoutY(100);
        var texx = "";
        for (var i = 0; i < texx.length(); i += 1) {
            var text = new Text(String.valueOf(texx.charAt(i)));
            text.setBoundsType(TextBoundsType.VISUAL);
            text.setTextOrigin(VPos.CENTER);
            text.setTextAlignment(TextAlignment.CENTER);
            text.setFill(Color.BLUE);
            text.setFont(Font.font(100));
            //       setPixelHeight(scene, text, 100);
            RowConstraints c = new RowConstraints(50);
            gridPane.getRowConstraints().add(c);
            gridPane.add(text, 0, i);

        }
        //   return line;
        //      return gridPane;
    }

    private ArrayList<Point2D> getPoints(Line line, int number_of_letters, int text_size) {
        var arr = new ArrayList<Point2D>();
        var x_1 = line.getStartX();
        var y_1 = line.getStartY();
        var x_2 = line.getEndX();
        var y_2 = line.getEndY();
        var a = (int) x_2 - x_1;
        var b = (int) y_2 - y_1;

        //      System.out.println(a + "aa" + b + "bb");
        var size = (int) Math.floor(Math.sqrt(a * a + b * b));
        var ss = (text_size) / (size * 0.01) * 0.01;
        var x_3 = (int) a * ss;
        var y_3 = (int) b * ss;
        getChildren().add(new Circle(x_1 + x_3, y_1 + y_3, 10, Color.GREEN));
        //   System.out.println(size - (number_of_letters * text_size) - ((number_of_letters - 1) * 2));
        for (var i = 1; i <= number_of_letters; i += 1) {
            var t = (text_size * i) / size;
            var xt = (1 - t) * x_1 + t * x_2;
            var yt = (1 - t) * y_1 + t * y_2;
            getChildren().add(new Circle(xt, yt, 10, Color.TURQUOISE));
        }
        return arr;
    }

    private static <S extends Path> ArrayList<S> draw(double lineXX, double lineYY, double moveXX, double moveYY, Function<PathElement[], S> shapeConstructor) {
        var lineX = HEIGHT_50 * 2 * lineXX;
        var lineY = HEIGHT_50 * 2 * lineYY;
        var moveX = HEIGHT_50 * 2 * moveXX;
        var moveY = HEIGHT_50 * 2 * moveYY;
        var paths = new ArrayList<>();
        paths.addAll(carts_arc(lineX, lineY, moveX, moveY, subtraction, subtraction, shapeConstructor));
        paths.addAll(carts_line(lineX, lineY, moveX, moveY, subtraction, subtraction, shapeConstructor));
        paths.addAll(carts_arc(lineX, lineY, moveX, moveY, addition, subtraction, shapeConstructor));
        paths.addAll(carts_line(lineY, lineX, moveY, moveX, addition, subtraction, shapeConstructor));
        paths.addAll(carts_arc(lineX, lineY, moveX, moveY, addition, addition, shapeConstructor));
        paths.addAll(carts_line(lineX, lineY, moveX, moveY, addition, addition, shapeConstructor));
        paths.addAll(carts_arc(lineX, lineY, moveX, moveY, subtraction, addition, shapeConstructor));
        paths.addAll(carts_line(lineY, lineX, moveY, moveX, subtraction, addition, shapeConstructor));
        return (ArrayList) paths.stream().sorted((p1, p2) -> {
            var path1 = paths.indexOf(p1);
            var path2 = paths.indexOf(p2);
            if ((path1 >= 22 && path2 >= 22) || (path1 <= 21 && path2 <= 21)) {
                return path1 - path2;
            } else {
                return path2 - path1;
            }
        }).collect(Collectors.toList());
    }

    private static <S extends Path> ArrayList<S> carts_arc(double lineX, double lineY, double moveX, double moveY, DoubleBinaryOperator x, DoubleBinaryOperator y, Function<PathElement[], S> shapeConstructor) {
        S path;
        var c = Math.sqrt(lineX * lineX + lineY * lineY);
        var degs = Math.toDegrees(Math.acos((lineX * lineX + c * c - lineY * lineY) / (2 * c * lineX)));
        var angles = (90 - 2 * degs) / 5;
        var paths = new ArrayList<>();
        var arc_big = Math.sqrt(lineX * lineX + lineY * lineY);
        var arc_small = Math.sqrt(moveY * moveY + moveX * moveX);
        var lineTo = new LineTo(x.applyAsDouble(HEIGHT_50, lineX), y.applyAsDouble(HEIGHT_50, lineY));
        var moveToCenter = new MoveTo(x.applyAsDouble(HEIGHT_50, moveX), y.applyAsDouble(HEIGHT_50, moveY));
        for (var deg = degs + angles; deg <= 90 - degs; deg += angles) {
            path = shapeConstructor.apply(new PathElement[]{moveToCenter, lineTo});
            lineTo = new LineTo(x.applyAsDouble(HEIGHT_50, arc_big * Math.cos(Math.toRadians(deg))), y.applyAsDouble(HEIGHT_50, arc_big * Math.sin(Math.toRadians(deg))));
            path.getElements().add(new ArcTo(arc_big, arc_big, 0, lineTo.getX(), lineTo.getY(), false, x == y));
            var move = new MoveTo(x.applyAsDouble(HEIGHT_50, arc_small * Math.cos(Math.toRadians(deg))), y.applyAsDouble(HEIGHT_50, arc_small * Math.sin(Math.toRadians(deg))));
            path.getElements().addAll(new LineTo(move.getX(), move.getY()),
                    new ArcTo(arc_small, arc_small, 0, moveToCenter.getX(), moveToCenter.getY(), false, x != y));
            moveToCenter = move;
            paths.add(path);
        }
        if (x != y) {
            Collections.reverse(paths);
        }
        return (ArrayList) paths;

    }

    private static <S extends Path> ArrayList<S> carts_line(double lineX, double lineY, double moveX, double moveY, DoubleBinaryOperator x, DoubleBinaryOperator y, Function<PathElement[], S> shapeConstructor) {
        S path;
        var paths = new ArrayList<>();
        var big = 2 * lineY / 5;
        var small = 2 * moveY / 5;
        var x2 = x.applyAsDouble(HEIGHT_50, lineY);
        var y2 = y.applyAsDouble(HEIGHT_50, lineX);
        var x1 = x.applyAsDouble(HEIGHT_50, moveY);
        var y1 = y.applyAsDouble(HEIGHT_50, moveX);
        var numberX = 1;
        var numberY = 1;
        if (x == y) {
            numberX = 0;
            if (x == addition) {
                numberY = -1;
            }
        } else {
            numberY = 0;
            small = 2 * lineX / 5;
            big = 2 * moveX / 5;
            if (x == subtraction) {
                numberX = -1;
            }
        }
        for (var part = 1; part <= 5; part += 1) {
            path = shapeConstructor.apply(new PathElement[]{new MoveTo(x1 + (part - 1) * small * numberY, y1 + (part - 1) * big * numberX),
                new LineTo(x2 + (part - 1) * big * numberY, y2 + (part - 1) * small * numberX),
                new LineTo(x2 + part * big * numberY, y2 + part * small * numberX),
                new LineTo(x1 + part * small * numberY, y1 + part * big * numberX),
                new LineTo(x1 + (part - 1) * small * numberY, y1 + (part - 1) * big * numberX)});
            paths.add(path);
        }
        return (ArrayList) paths;
    }
}
