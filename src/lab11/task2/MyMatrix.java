package lab11.task2;


import java.util.Arrays;

public class MyMatrix implements Summable {
    Double[][] matrix = new Double[4][4];
    private Summable value;

    public MyMatrix(MyMatrix newMatrix) {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                this.matrix[i][j] = newMatrix.matrix[i][j];
            }
    }

    public MyMatrix() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.matrix[i][j] = 0d;
            }
        }
    }

    @Override
    public void addValue(Summable value) {
        this.value = value;
        MyMatrix matrixToAdd = new MyMatrix((MyMatrix) value);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.matrix[i][j] += matrixToAdd.matrix[i][j];
            }
        }
    }

    @Override
    public String toString() {
        String lineSeparator = System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        for (var row : this.matrix) {
            sb.append(Arrays.toString(row));
            sb.append(lineSeparator);
        }

        String result;
        result = sb.toString();

        return new StringBuilder().append("MyMatrix{").append("matrix=\n").append(result).append('}').toString();
    }
}
