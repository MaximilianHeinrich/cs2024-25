package dev.maximilian;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {

    public String name;

    public Node(String name) {
        this.name = name;
    }
}
