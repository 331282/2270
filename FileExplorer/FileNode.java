package FileExplorer;

import java.util.ArrayList;

public class FileNode {
    
    String name;
    boolean isFolder;
    int size;
    ArrayList<FileNode> children;

    public FileNode(String name, boolean isFolder, int size) {
        this.name = name;
        this.isFolder = isFolder;
        this.size = size;
        this.children = new ArrayList<>();
    }

    public void addChild(FileNode child) {
        if (isFolder) children.add(child);
    }
}

