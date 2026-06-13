package FileExplorer;

public class FileExplorer {

    public static void printTree(FileNode node, int depth) {
        String tabs = "";
        for (int i = 0; i < depth; i++) {
            tabs += "   ";
        } 

        System.out.println(tabs + node.name);

        if (node.isFolder) {
            for (FileNode child : node.children) {
                printTree(child, depth + 1);
            }
        }
    }

    public static int countFiles(FileNode node) {
        int count = 0;
        if (node.isFolder) {
            for (FileNode child : node.children) {
                count += countFiles(child);
            }
        } else {
            count ++;
        }
        return count;
    }

    public static int totalSize(FileNode node) {
        int size = 0;
        size += node.size;
        if (node.isFolder) {
            for (FileNode child : node.children) {
                size += totalSize(child);
            }
        }
        return size;
    }

    public static boolean search(FileNode node, String target) {
        if (node.name.equals(target)) {
            return true;
        }
        if (node.isFolder) {
            for (FileNode child : node.children) {
                if(search(child, target)) {
                    return true;
                }
            }
        }
        return false;
    }
}
