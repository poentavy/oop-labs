package lab11.task2;

import java.util.*;

public class Main {
    public static <T extends Summable> void addAll(Collection<T> c, Vector vector, MyMatrix matrix) {
        for (T o : c) {
            if (o instanceof MyMatrix) {
                matrix.addValue(o);
            } else {
                vector.addValue(o);
            }
        }
    }

    public static void main(final String[] args) {
        Vector vector1 = new Vector(1.1, 4.2, 5.5);
        Vector vector2 = new Vector(3.1, 2.22, 1.75);
        Vector vector3 = new Vector(4.25, 2.18, 3.25);

        MyMatrix matrix1 = new MyMatrix();
        MyMatrix matrix2 = new MyMatrix();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix1.matrix[i][j] = Double.valueOf(j + i);
                matrix2.matrix[i][j] = Double.valueOf(j * i);
            }
        }

        List<Summable> list = new ArrayList<>();
        list.add(vector1);
        list.add(vector2);
        list.add(vector3);
        list.add(matrix1);
        list.add(matrix2);

        Vector finalVector = new Vector();
        MyMatrix finalMatrix = new MyMatrix();

        addAll(list, finalVector, finalMatrix);

        System.out.println(finalVector);
        System.out.println(finalMatrix);

    }
}
