package codewars.shortestKnightPath;

import java.util.*;

public class Knight {

    private static final List<String> row = new ArrayList<>();

    private static int knight(String startingPosition, String endPosition) {
        Collections.addAll(row, "a", "b", "c", "d", "e", "f", "g", "h");
        HashMap<String, Queue<String>> graph = new HashMap<>();
        graph.put(startingPosition, moves(startingPosition));
        Set<String> keys = graph.keySet();
        String key = keys.iterator().next();
        Queue<String> positionsToCheckInCurrentDepth = new LinkedList<>();
        Queue<String> positionsToCheck = new LinkedList<>(graph.get(key));

        int counter = 0;
        List<String> checked = new ArrayList<>();
        checked.add(startingPosition);
        while (!positionsToCheck.isEmpty()) {
            System.out.println(positionsToCheckInCurrentDepth);
            if (positionsToCheckInCurrentDepth.size() == 0) {
                positionsToCheckInCurrentDepth.addAll(positionsToCheck);
                counter++;
            }
            String position = positionsToCheckInCurrentDepth.poll();


            if (checked.contains(position)) continue;

            assert position != null;
            if (position.equals(endPosition)) return counter;

            checked.add(position);
            graph.put(position, moves(position));
            positionsToCheck.addAll(graph.get(position));


        }
        return counter;
    }

    private static Queue<String> moves(String position) {
        int rowIndex = row.indexOf(Arrays.asList(position.split("")).get(0));
        int column = Integer.parseInt(Arrays.asList(position.split("")).get(1));
        Queue<String> moves = new LinkedList<>();


        if (isLegal(rowIndex - 1, column - 2)) moves.add(row.get(rowIndex - 1) + (column - 2));
        if (isLegal(rowIndex - 2, column - 1)) moves.add(row.get(rowIndex - 2) + (column - 1));
        if (isLegal(rowIndex - 2, column + 1)) moves.add(row.get(rowIndex - 2) + (column + 1));
        if (isLegal(rowIndex - 1, column + 2)) moves.add(row.get(rowIndex - 1) + (column + 2));
        if (isLegal(rowIndex + 1, column + 2)) moves.add(row.get(rowIndex + 1) + (column + 2));
        if (isLegal(rowIndex + 2, column + 1)) moves.add(row.get(rowIndex + 2) + (column + 1));
        if (isLegal(rowIndex + 2, column - 1)) moves.add(row.get(rowIndex + 2) + (column - 1));
        if (isLegal(rowIndex + 1, column - 2)) moves.add(row.get(rowIndex + 1) + (column - 2));

        return moves;
    }

    private static boolean isLegal(int rowIndex, int column) {
        int points = 0;
        if (rowIndex >= 0 && rowIndex <= 7) points++;
        if (column > 0 && column < 9) points++;

        return points == 2;
    }


}
