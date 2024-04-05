import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.stream.Collectors;

public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.addLoadListener(new LoadListener());
        view.addSaveListener(new SaveListener());
        view.addTraverseListener(new TraverseListener());
    }

    class LoadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle loading action
            // Assuming filePath is provided
            model.loadFromFile("path_to_file");
            view.setText(String.join("\n", model.getTextLines()));
        }
    }

    class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle saving action
            // Assuming filePath is provided
            model.setTextLines(view.getText().lines().collect(Collectors.toList()));
            model.saveToFile("path_to_file");
            view.showMessage("File saved successfully!");
        }
    }

    class TraverseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle folder traversal action
            // Assuming folderPath is provided
            File folder = new File("path_to_folder");
            model.recursiveFolderTraversal(folder);
            view.showMessage("Folder traversal completed!");
        }
    }
}