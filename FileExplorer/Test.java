package FileExplorer;

public class Test {
    public static void main(String[] args) {
        FileNode root = new FileNode("root", true, 0);

        FileNode images = new FileNode("images", true, 0);
        images.addChild(new FileNode("cat.png", false, 120));
        images.addChild(new FileNode("dog.png", false, 200));

        FileNode docs = new FileNode("docs", true, 0);
        docs.addChild(new FileNode("resume.pdf", false, 300));
        docs.addChild(new FileNode("notes.txt", false, 50));

        root.addChild(images);
        root.addChild(docs);

        FileExplorer.printTree(root, 0);
        System.out.println(FileExplorer.countFiles(root));
        System.out.println(FileExplorer.totalSize(root));
        System.out.println(FileExplorer.search(root, "cat.png"));

    }
}
