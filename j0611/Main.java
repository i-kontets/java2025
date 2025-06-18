package j0611;

import java.io.File;

public class Main {
    //フォルダ(ファイル)を削除するプログラム
    public static void main(String[] args) {
        //削除したいフォルダのパスを保存する変数
        String folderPath = "C://tmp";
        File folder = new File(folderPath);

        //フォルダが存在しているか確認
        //ファイルを削除できたか確認する処理
        if(deleteFolder(folder)){
            System.out.println("フォルダを削除しました" + folderPath);
        }else{
            System.out.println("フォルダの削除に失敗しました" + folderPath);
        }
    }

    //再帰的にフォルダと中身を削除するメソッド
    public static boolean deleteFolder(File folder) {
        //フォルダが存在してなかったらfalseを返す
        if(folder.exists() == false){
            return false;
        }

        //フォルダ無いのファイルあサブフォルダをすべて削除する
        File[] files = folder.listFiles();
        if(files != null){
            //拡張for(PHPでいうforeach)
            //ファイルのみ削除するプログラム
            for(File file : files){
                if(file.isDirectory()){
                    deleteFolder(file);//再帰呼び出し
                }else{
                    file.delete();//ファイル削除
                }
            }
        }

        //最後にフォルダ自身を削除
        return folder.delete();
    }

}
