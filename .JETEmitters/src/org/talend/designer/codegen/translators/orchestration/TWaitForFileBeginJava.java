package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TWaitForFileBeginJava
{
  protected static String nl;
  public static synchronized TWaitForFileBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWaitForFileBeginJava result = new TWaitForFileBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Start to scan the folder '\" + ";
  protected final String TEXT_3 = " + \"'\" + ";
  protected final String TEXT_4 = ");" + NL + "\t\tlog.debug(\"";
  protected final String TEXT_5 = " - Filemask : '\" + ";
  protected final String TEXT_6 = " + \"'.\" + ";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "       " + NL + "        class Util_";
  protected final String TEXT_9 = " {" + NL + "" + NL + "            private boolean flagt = false;" + NL + "" + NL + "            private java.util.regex.Pattern fileNamePatternt = null;" + NL + "        \tprivate java.util.List<String> list;" + NL + "\t\t\tpublic java.util.List<String> getFiles(){" + NL + "\t\t\t\tsetFiles();" + NL + "\t\t\t\treturn list;" + NL + "\t\t\t}";
  protected final String TEXT_10 = NL + "\t\t\tprivate java.util.Map<String, Long> originalTimeMap;" + NL + "\t\t\tprivate java.util.Map<String, String> originalContentMap;" + NL + "\t\t\tprivate boolean initMap = false;" + NL + "\t\t\tpublic Util_";
  protected final String TEXT_11 = "(){" + NL + "\t\t\t}" + NL + "\t\t\tpublic Util_";
  protected final String TEXT_12 = "(boolean iniMap){" + NL + "\t\t\t\tlist = new java.util.ArrayList<String>();" + NL + "\t\t\t\tif(iniMap){" + NL + "\t\t\t\t\tthis.initMap = true;" + NL + "\t\t\t\t\toriginalTimeMap = new java.util.HashMap<String, Long>();" + NL + "\t\t\t\t\toriginalContentMap = new java.util.HashMap<String, String>();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tpublic void addFile(java.io.File file){" + NL + "\t\t\t\tlist.add(file.getPath());" + NL + "\t\t\t\tif(initMap){" + NL + "\t\t\t\t\toriginalTimeMap.put(file.getPath(), file.lastModified());" + NL + "\t\t\t\t\toriginalContentMap.put(file.getPath(),getFileChecksum(file));" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tpublic java.util.Map<String, Long> getTimeMap(){" + NL + "\t\t\t\treturn originalTimeMap;" + NL + "\t\t\t}" + NL + "\t\t\tpublic java.util.Map<String, String> getContentMap(){" + NL + "\t\t\t\treturn originalContentMap;" + NL + "\t\t\t}" + NL + "\t\t\tpublic String getFileChecksum(java.io.File file) {" + NL + "            \tString strMD5 = \"\";" + NL + "            \tjava.security.MessageDigest complete = null;" + NL + "            \tjava.io.InputStream fis = null;" + NL + "            \ttry{" + NL + "                    fis =  new java.io.FileInputStream(file);" + NL + "                    byte[] buffer = new byte[1024];" + NL + "                    complete = java.security.MessageDigest.getInstance(\"MD5\");" + NL + "                    int numRead;" + NL + "                    while((numRead = fis.read(buffer))!= -1){" + NL + "                      \tif (numRead > 0) {" + NL + "                        \tcomplete.update(buffer, 0, numRead);" + NL + "                        }" + NL + "                    }" + NL + "                } catch(java.lang.Exception ex) {" + NL + "                \t";
  protected final String TEXT_13 = NL + "                \t\tlog.warn(\"";
  protected final String TEXT_14 = " - \" + ex.getMessage());" + NL + "                \t";
  protected final String TEXT_15 = NL + "                } finally {" + NL + "                \tif(fis != null) {" + NL + "                \t\ttry {" + NL + "                \t\t\tfis.close();" + NL + "                \t\t} catch(java.lang.Exception ex) {" + NL + "                \t\t";
  protected final String TEXT_16 = NL + "                \t\t\tlog.warn(\"";
  protected final String TEXT_17 = " - \" + ex.getMessage());" + NL + "                \t\t";
  protected final String TEXT_18 = NL + "                \t\t}" + NL + "                \t}" + NL + "                }" + NL + "               \t" + NL + "               \tif(complete != null){" + NL + "        \t\t\tbyte[] b = complete.digest();" + NL + "         \t\t\tfor (int i = 0; i < b.length; i++) {" + NL + "          \t\t\t\tstrMD5 += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );" + NL + "          \t\t\t}" + NL + "      \t\t\t}" + NL + "        \t\treturn strMD5;" + NL + "            }";
  protected final String TEXT_19 = NL + "        \tpublic Util_";
  protected final String TEXT_20 = "(){" + NL + "\t\t\t\tthis.list = new java.util.ArrayList<String>();" + NL + "\t\t\t}" + NL + "\t\t\tpublic void addFile(java.io.File file){" + NL + "\t\t\t\tthis.list.add(file.getPath());" + NL + "\t\t\t}";
  protected final String TEXT_21 = NL + "            void setFiles() {" + NL + "                String directoryt = ";
  protected final String TEXT_22 = ";" + NL + "                String filemaskt = ";
  protected final String TEXT_23 = "+\"$\";" + NL + "" + NL + "                if (filemaskt.indexOf(\"^\") == -1) {" + NL + "                    filemaskt = \"^\" + filemaskt;" + NL + "                }" + NL + "                if (!(filemaskt.lastIndexOf(\".*$\") == -1) && filemaskt.lastIndexOf(\"*.*$\") == -1) {" + NL + "                    filemaskt = filemaskt.substring(0, filemaskt.length() - 3) + \"$\";" + NL + "                    flagt = true;" + NL + "                } else {" + NL + "                    filemaskt = java.util.regex.Pattern.compile(\"[*]\").matcher(filemaskt).replaceAll(\".*\");" + NL + "                }" + NL + "" + NL + "                boolean case_sensitivet = ";
  protected final String TEXT_24 = ";" + NL + "                fileNamePatternt = java.util.regex.Pattern.compile(filemaskt);" + NL + "                if (!case_sensitivet) {" + NL + "                    fileNamePatternt = java.util.regex.Pattern.compile(filemaskt, java.util.regex.Pattern.CASE_INSENSITIVE);" + NL + "                }" + NL + "                java.io.File filet = new java.io.File(directoryt);" + NL + "                filet.listFiles(new java.io.FilenameFilter() {" + NL + "" + NL + "                    public boolean accept(java.io.File dir, String name) {" + NL + "                        java.io.File file = new java.io.File(dir, name);" + NL + "                        if (file.isFile()) {" + NL + "                            String fileNamet = name;" + NL + "                            if (flagt == true) {" + NL + "                                if (!(fileNamet.indexOf(\".\") == -1)) {" + NL + "                                    if (fileNamePatternt.matcher(fileNamet.substring(0, fileNamet.indexOf(\".\"))).find()) {" + NL + "                                        addFile(file);" + NL + "" + NL + "                                    }" + NL + "                                } else {" + NL + "                                    if (fileNamePatternt.matcher(fileNamet).find()) {" + NL + "                                        addFile(file);" + NL + "                                    }" + NL + "                                }" + NL + "                            } else {" + NL + "                                if (fileNamePatternt.matcher(fileNamet).find()) {" + NL + "                                    addFile(file);" + NL + "                                }" + NL + "                            }" + NL + "" + NL + "                            return true;" + NL + "                        } ";
  protected final String TEXT_25 = "                          " + NL + "                            else {" + NL + "" + NL + "                                file.listFiles(this);" + NL + "                            }" + NL + "                      ";
  protected final String TEXT_26 = "                        " + NL + "                        return false;" + NL + "                    }" + NL + "" + NL + "                });" + NL + "" + NL + "            }";
  protected final String TEXT_27 = NL + "\t\t\tjava.util.List<java.io.File> getCreatedFiles(java.util.List<String> originalFiles, java.util.List<String> fetchOneTimeFiles) {" + NL + "\t\t\t\tjava.util.List<java.io.File> newCreatedFiles = new java.util.ArrayList<java.io.File>();" + NL + "\t\t\t\tString [] array = originalFiles.toArray(new String[]{});" + NL + "\t\t\t\tfor(String file: fetchOneTimeFiles){" + NL + "\t\t\t\t\tint index = java.util.Arrays.binarySearch(array, file);" + NL + "\t\t\t\t\tif(index<0){" + NL + "\t\t\t\t\t\tnewCreatedFiles.add(new java.io.File(file));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn newCreatedFiles;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_28 = NL + "        }" + NL + "            " + NL + "        Util_";
  protected final String TEXT_29 = " util_";
  protected final String TEXT_30 = " = new Util_";
  protected final String TEXT_31 = "(";
  protected final String TEXT_32 = "true";
  protected final String TEXT_33 = ");" + NL + "        java.util.List<String> originalFiles_";
  protected final String TEXT_34 = " = util_";
  protected final String TEXT_35 = ".getFiles();            ";
  protected final String TEXT_36 = NL + "            java.util.Map<String,Long> originalMap_";
  protected final String TEXT_37 = ".getTimeMap();" + NL + "            java.util.Map<String,String> originalContentMap_";
  protected final String TEXT_38 = ".getContentMap();";
  protected final String TEXT_39 = NL + "      " + NL + "        int count_";
  protected final String TEXT_40 = " = 0;" + NL + "        ";
  protected final String TEXT_41 = NL + "        String osName_";
  protected final String TEXT_42 = " = System.getProperty(\"os.name\");" + NL + "        boolean isWindows_";
  protected final String TEXT_43 = " = osName_";
  protected final String TEXT_44 = " != null && osName_";
  protected final String TEXT_45 = ".toLowerCase().startsWith(\"win\");";
  protected final String TEXT_46 = NL + "        " + NL + "        while (true) {";
  protected final String TEXT_47 = "                " + NL + "                if (count_";
  protected final String TEXT_48 = " == ";
  protected final String TEXT_49 = " ) {";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_51 = " - The maximum iteration number has been reached. Breaking the loop.\");";
  protected final String TEXT_52 = NL + "                    break;" + NL + "                }";
  protected final String TEXT_53 = "                " + NL + "            boolean found_";
  protected final String TEXT_54 = " = false;";
  protected final String TEXT_55 = NL + "\t\t\t\tif(globalMap.get(\"";
  protected final String TEXT_56 = "_PRESENT_FILE\") != null){" + NL + "\t                globalMap.remove(\"";
  protected final String TEXT_57 = "_PRESENT_FILE\");" + NL + "\t\t\t\t}              " + NL + "    \t\t\tif( count_";
  protected final String TEXT_58 = " < originalFiles_";
  protected final String TEXT_59 = ".size()) {" + NL + "                    java.io.File file_";
  protected final String TEXT_60 = " = new java.io.File(originalFiles_";
  protected final String TEXT_61 = ".get(count_";
  protected final String TEXT_62 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_63 = " - File '\" + file_";
  protected final String TEXT_64 = ".getName() + \"' already exists in the listen folders.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_65 = NL + "                    globalMap.put(\"";
  protected final String TEXT_66 = "_FILENAME\", file_";
  protected final String TEXT_67 = ".getName());" + NL + "                    globalMap.put(\"";
  protected final String TEXT_68 = "_PRESENT_FILE\", file_";
  protected final String TEXT_69 = ".getAbsolutePath());" + NL + "                    found_";
  protected final String TEXT_70 = " = true;" + NL + "    \t\t\t} else {" + NL + "\t\t\t    ";
  protected final String TEXT_71 = NL + "\t\t\tutil_";
  protected final String TEXT_72 = "false";
  protected final String TEXT_73 = ");" + NL + "\t\t\t" + NL + "            java.util.List<String> fetchFilesOneTime_";
  protected final String TEXT_74 = ".getFiles();" + NL + "            " + NL + "\t\t\tList<String> intersectionList = new java.util.ArrayList<String>();" + NL + "\t\t\t" + NL + "\t\t\tfor(String cachedFile : originalFiles_";
  protected final String TEXT_75 = ")" + NL + "\t\t\t{" + NL + "\t\t\t\tif(fetchFilesOneTime_";
  protected final String TEXT_76 = ".contains(cachedFile))" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tintersectionList.add(cachedFile);" + NL + "\t\t\t\t}" + NL + "\t\t\t}     " + NL + "            " + NL + "            util_";
  protected final String TEXT_77 = "();";
  protected final String TEXT_78 = NL + "\t\t\t\toriginalFiles_";
  protected final String TEXT_79 = " = intersectionList;" + NL + "            \tif(globalMap.get(\"";
  protected final String TEXT_80 = "_CREATED_FILE\") != null){" + NL + "\t                globalMap.remove(\"";
  protected final String TEXT_81 = "_CREATED_FILE\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\tjava.util.Collections.sort(originalFiles_";
  protected final String TEXT_82 = ");" + NL + "                java.util.List<java.io.File> newCreatedFiles_";
  protected final String TEXT_83 = ".getCreatedFiles(originalFiles_";
  protected final String TEXT_84 = ",fetchFilesOneTime_";
  protected final String TEXT_85 = ");" + NL + "" + NL + "               \tfor ( int i=0; i< newCreatedFiles_";
  protected final String TEXT_86 = ".size(); i++) {" + NL + "\t\t\t\t\tjava.io.File file_";
  protected final String TEXT_87 = " = newCreatedFiles_";
  protected final String TEXT_88 = ".get(i);" + NL + "           \t\t\t";
  protected final String TEXT_89 = NL + "\t  \t\t\t\tif (isWindows_";
  protected final String TEXT_90 = "){" + NL + "\t  \t\t\t\t\tjava.io.File tempfile_";
  protected final String TEXT_91 = " =new java.io.File(file_";
  protected final String TEXT_92 = ".getAbsolutePath()+\".talendTempfile\"); " + NL + "\t  \t\t\t\t\tThread.sleep(";
  protected final String TEXT_93 = ");" + NL + "\t  \t\t\t\t\tif(file_";
  protected final String TEXT_94 = ".renameTo(tempfile_";
  protected final String TEXT_95 = ")) {" + NL + "\t  \t\t\t\t\t\ttempfile_";
  protected final String TEXT_96 = ".renameTo(file_";
  protected final String TEXT_97 = "); " + NL + "\t  \t\t\t\t\t} else {" + NL + "\t  \t\t\t\t\t\tcontinue;" + NL + "\t  \t\t\t\t\t}" + NL + "\t  \t\t\t\t} else { " + NL + "\t\t\t\t\t\tlong timestamp_";
  protected final String TEXT_98 = " = file_";
  protected final String TEXT_99 = ".lastModified();" + NL + "\t" + NL + "\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_100 = ");" + NL + "\t" + NL + "\t                \tif(file_";
  protected final String TEXT_101 = ".lastModified() != timestamp_";
  protected final String TEXT_102 = "){" + NL + "\t                \t\tcontinue;" + NL + "\t                \t}" + NL + "\t                }" + NL + "            \t\t";
  protected final String TEXT_103 = NL + "\t\t\t\t\t";
  protected final String TEXT_104 = ".getName() + \"' has been created.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_105 = "_CREATED_FILE\", file_";
  protected final String TEXT_106 = " = true;" + NL + "                    originalFiles_";
  protected final String TEXT_107 = ".add(file_";
  protected final String TEXT_108 = ".getPath());              " + NL + "                    break;" + NL + "            \t}" + NL + "\t\t\t";
  protected final String TEXT_109 = NL + "            \tif(globalMap.get(\"";
  protected final String TEXT_110 = "_DELETED_FILE\") != null){" + NL + "\t                globalMap.remove(\"";
  protected final String TEXT_111 = "_DELETED_FILE\");" + NL + "\t\t\t\t}" + NL + "            \tjava.util.Collections.sort(fetchFilesOneTime_";
  protected final String TEXT_112 = ");" + NL + "            \tString [] arrayFetchFilesOneTime_";
  protected final String TEXT_113 = " = fetchFilesOneTime_";
  protected final String TEXT_114 = ".toArray(new String[]{});" + NL + "            \tfor(String str_";
  protected final String TEXT_115 = " : originalFiles_";
  protected final String TEXT_116 = ") {" + NL + "            \t\tint index_delete_";
  protected final String TEXT_117 = " = java.util.Arrays.binarySearch(arrayFetchFilesOneTime_";
  protected final String TEXT_118 = ",str_";
  protected final String TEXT_119 = ");" + NL + "                    if(index_delete_";
  protected final String TEXT_120 = " < 0) {" + NL + "\t            \t\tjava.io.File file_";
  protected final String TEXT_121 = " = new java.io.File(str_";
  protected final String TEXT_122 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_123 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_124 = ".getName() + \"' has been deleted.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_125 = NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_126 = ".getName());" + NL + "                        globalMap.put(\"";
  protected final String TEXT_127 = "_DELETED_FILE\", file_";
  protected final String TEXT_128 = ".getAbsolutePath());" + NL + "                        found_";
  protected final String TEXT_129 = " = true;  " + NL + "                        originalFiles_";
  protected final String TEXT_130 = ".remove(str_";
  protected final String TEXT_131 = ");                  " + NL + "                        break;" + NL + "                    }" + NL + "                }";
  protected final String TEXT_132 = NL + "                for(String str_";
  protected final String TEXT_133 = " : fetchFilesOneTime_";
  protected final String TEXT_134 = ") {" + NL + "                \tjava.io.File file_";
  protected final String TEXT_135 = ");" + NL + "                \t" + NL + "            \t";
  protected final String TEXT_136 = NL + "\t\t\t\t\tif (isWindows_";
  protected final String TEXT_137 = "){" + NL + "\t\t\t\t\t\tjava.io.File tempfile_";
  protected final String TEXT_138 = ".getAbsolutePath()+\".talendTempfile\");" + NL + "\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_139 = ");" + NL + "\t\t\t\t\t\tif(file_";
  protected final String TEXT_140 = "); " + NL + "\t  \t\t\t\t\t} else {" + NL + "\t  \t\t\t\t\t\tcontinue;" + NL + "\t  \t\t\t\t\t}" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tlong timestamp_";
  protected final String TEXT_141 = "){" + NL + "\t                \t\tcontinue;" + NL + "\t                \t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_142 = NL + "\t\t\t\t";
  protected final String TEXT_143 = NL + "                \tif(globalMap.get(\"";
  protected final String TEXT_144 = "_UPDATED_FILE\") != null){" + NL + "\t                \tglobalMap.remove(\"";
  protected final String TEXT_145 = "_UPDATED_FILE\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(originalMap_";
  protected final String TEXT_146 = ".get(str_";
  protected final String TEXT_147 = ")==null ){" + NL + "                    \toriginalMap_";
  protected final String TEXT_148 = ".put(str_";
  protected final String TEXT_149 = ",file_";
  protected final String TEXT_150 = ".lastModified());" + NL + "                    \toriginalContentMap_";
  protected final String TEXT_151 = ",util_";
  protected final String TEXT_152 = ".getFileChecksum(file_";
  protected final String TEXT_153 = "));" + NL + "\t\t\t\t\t} else if(originalMap_";
  protected final String TEXT_154 = ")!=file_";
  protected final String TEXT_155 = ".lastModified()) {" + NL + "                        originalMap_";
  protected final String TEXT_156 = ".lastModified());" + NL + "                        String fileMD5_";
  protected final String TEXT_157 = ");" + NL + "\t\t\t\t\t\tif(!fileMD5_";
  protected final String TEXT_158 = ".equals(originalContentMap_";
  protected final String TEXT_159 = "))){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_160 = NL + "\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_161 = ".getName() + \"' has been updated.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_162 = NL + "\t                    \tglobalMap.put(\"";
  protected final String TEXT_163 = ".getName());" + NL + "\t                        globalMap.put(\"";
  protected final String TEXT_164 = "_UPDATED_FILE\", file_";
  protected final String TEXT_165 = ".getAbsolutePath());" + NL + "\t                       \tfound_";
  protected final String TEXT_166 = " = true;" + NL + "\t                        originalContentMap_";
  protected final String TEXT_167 = ",fileMD5_";
  protected final String TEXT_168 = ");" + NL + "\t                        break;" + NL + "\t\t\t\t\t\t}" + NL + "                    }" + NL + "            \t";
  protected final String TEXT_169 = NL + "            \t\tif(globalMap.get(\"";
  protected final String TEXT_170 = "_NOT_UPDATED_FILE\") != null){" + NL + "\t                \tglobalMap.remove(\"";
  protected final String TEXT_171 = "_NOT_UPDATED_FILE\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(originalMap_";
  protected final String TEXT_172 = ".lastModified()) {" + NL + "            \t\t\toriginalMap_";
  protected final String TEXT_173 = ".lastModified());" + NL + "\t            \t\tString fileMD5_";
  protected final String TEXT_174 = ");" + NL + "            \t\t\tif(!fileMD5_";
  protected final String TEXT_175 = "))){" + NL + "\t\t\t\t\t\t\toriginalContentMap_";
  protected final String TEXT_176 = ");" + NL + "\t            \t\t\tglobalMap.put(\"";
  protected final String TEXT_177 = "_NOT_UPDATED_FILE\", null);" + NL + "\t            \t\t\tfound_";
  protected final String TEXT_178 = " = false;" + NL + "            \t\t\t}else{" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_179 = ".getName());" + NL + "\t                    \tglobalMap.put(\"";
  protected final String TEXT_180 = "_NOT_UPDATED_FILE\", file_";
  protected final String TEXT_181 = ".getAbsolutePath());" + NL + "\t                    \tfound_";
  protected final String TEXT_182 = " = true;" + NL + "\t                    \tbreak;" + NL + "                    \t}" + NL + "                   \t}else{                   " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_183 = ".getName() + \"' has been updated.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_184 = ".getName());" + NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_185 = ".getAbsolutePath());" + NL + "                    \tfound_";
  protected final String TEXT_186 = " = true;" + NL + "                    \tbreak;" + NL + "                    }";
  protected final String TEXT_187 = NL + "                }    " + NL + "                ";
  protected final String TEXT_188 = NL + "\t            if(globalMap.get(\"";
  protected final String TEXT_189 = "_DELETED_FILE\");" + NL + "\t\t\t\t}" + NL + "\t            if(globalMap.get(\"";
  protected final String TEXT_190 = "_CREATED_FILE\");" + NL + "\t\t\t\t}" + NL + "\t            if(globalMap.get(\"";
  protected final String TEXT_191 = "_UPDATED_FILE\") != null){" + NL + "\t                globalMap.remove(\"";
  protected final String TEXT_192 = "_UPDATED_FILE\");" + NL + "\t\t\t\t}" + NL + "                java.util.Collections.sort(originalFiles_";
  protected final String TEXT_193 = ");" + NL + "                java.util.Collections.sort(fetchFilesOneTime_";
  protected final String TEXT_194 = ");" + NL + "                String [] arrayFetchFilesOneTime_";
  protected final String TEXT_195 = ".toArray(new String[]{});" + NL + "                for(String str_";
  protected final String TEXT_196 = ") {" + NL + "                \tint index_fileall_";
  protected final String TEXT_197 = ");" + NL + "                    if(index_fileall_";
  protected final String TEXT_198 = " < 0 ) {" + NL + "\t                \tjava.io.File file_";
  protected final String TEXT_199 = " = true;" + NL + "                        originalFiles_";
  protected final String TEXT_200 = ");" + NL + "                        originalMap_";
  protected final String TEXT_201 = ");" + NL + "                    \toriginalContentMap_";
  protected final String TEXT_202 = ");" + NL + "                        break;" + NL + "                    }" + NL + "                }" + NL + "                java.util.List<java.io.File> newCreatedFiles_";
  protected final String TEXT_203 = ");" + NL + "                for ( int i=0; i< newCreatedFiles_";
  protected final String TEXT_204 = "){" + NL + "\t  \t\t\t\t\tjava.io.File tempfile=new java.io.File(file_";
  protected final String TEXT_205 = ".renameTo(tempfile)) {" + NL + "\t  \t\t\t\t\t\ttempfile.renameTo(file_";
  protected final String TEXT_206 = "){" + NL + "\t                \t\tcontinue;" + NL + "\t                \t}" + NL + "\t                }";
  protected final String TEXT_207 = ".getPath());           " + NL + "                    originalMap_";
  protected final String TEXT_208 = ".put(file_";
  protected final String TEXT_209 = ".getPath(),file_";
  protected final String TEXT_210 = ".lastModified());" + NL + "                    originalContentMap_";
  protected final String TEXT_211 = ".getPath(),util_";
  protected final String TEXT_212 = "));" + NL + "                    break;" + NL + "\t\t\t\t}" + NL + "                for(String str_";
  protected final String TEXT_213 = ");" + NL + "                \t" + NL + "\t\t\t\t\t";
  protected final String TEXT_214 = "){" + NL + "\t                \t\tcontinue;" + NL + "\t                \t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_215 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tif(originalMap_";
  protected final String TEXT_216 = ".lastModified());//occur repeat value              " + NL + "                        String fileMD5_";
  protected final String TEXT_217 = ");" + NL + "                        if(!fileMD5_";
  protected final String TEXT_218 = "))){" + NL + "                        \toriginalContentMap_";
  protected final String TEXT_219 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_220 = ".getAbsolutePath());" + NL + "\t                        found_";
  protected final String TEXT_221 = " = true;" + NL + "\t                        break;" + NL + "                        }" + NL + "                    }" + NL + "                }               ";
  protected final String TEXT_222 = NL;
  protected final String TEXT_223 = "   " + NL + "                }";
  protected final String TEXT_224 = NL + "            count_";
  protected final String TEXT_225 = "++;" + NL + "            " + NL + "            globalMap.put(\"";
  protected final String TEXT_226 = "_CURRENT_ITERATION\", count_";
  protected final String TEXT_227 = ");" + NL + "            " + NL + "            if (!found_";
  protected final String TEXT_228 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_229 = NL + "\t\t\t\t\tlog.trace(\"";
  protected final String TEXT_230 = " - Nothing appened. Waiting for ";
  protected final String TEXT_231 = " seconds and continue to loop.\");" + NL + "\t\t\t\t";
  protected final String TEXT_232 = NL + "            \tThread.sleep(";
  protected final String TEXT_233 = " * 1000);" + NL + "                continue;" + NL + "            }            " + NL;
  protected final String TEXT_234 = "\t" + NL + "\t\t";
  protected final String TEXT_235 = ".";
  protected final String TEXT_236 = " = ((";
  protected final String TEXT_237 = ")globalMap.get(\"";
  protected final String TEXT_238 = "_";
  protected final String TEXT_239 = "\"));";
  protected final String TEXT_240 = "            ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    boolean incldSubdir = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDE_SUBDIR__"));
    boolean present = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDE_PRESENT__"));
    String triggerAction = ElementParameterParser.getValue(node, "__ACTION_ON__");
    boolean waitRelease = ("true").equals(ElementParameterParser.getValue(node, "__WAIT_RELEASE__"));
    boolean nonUpdate = "true".equals(ElementParameterParser.getValue(node, "__NON_UPDATE__"));
    String interval = ElementParameterParser.getValue(node, "__INTERVAL_CHECK__");
	String directoryToScan = ElementParameterParser.getValue(node, "__DIRECTORY__");
	String usedFileMask = ElementParameterParser.getValue(node, "__FILEMASK__");
	boolean isCaseSensitive = "true".equals(ElementParameterParser.getValue(node, "__CASE_SENSITIVE__"));
	
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    if(isLog4jEnabled){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(directoryToScan);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(incldSubdir?"\" including subdirectories.\"":"\".\"");
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(usedFileMask);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(isCaseSensitive?"\" The filemask is case sensitive.\"":"\"\"");
    stringBuffer.append(TEXT_7);
    
	}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
        if(("fileupdated").equals(triggerAction) || ("fileall").equals(triggerAction)) {
        
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    
        }else{
        
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    
        }
        
    stringBuffer.append(TEXT_21);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DIRECTORY__") );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FILEMASK__"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CASE_SENSITIVE__") );
    stringBuffer.append(TEXT_24);
    
                        if(incldSubdir==true)  {
                            
    stringBuffer.append(TEXT_25);
    
                        }   
                        
    stringBuffer.append(TEXT_26);
    
			if(("filecreated").equals(triggerAction) || ("fileall").equals(triggerAction)) {

    stringBuffer.append(TEXT_27);
    
			}

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    if(("fileupdated").equals(triggerAction) || ("fileall").equals(triggerAction)) {
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    
        if(("fileupdated").equals(triggerAction) || ("fileall").equals(triggerAction)) {
            
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    
        }
        
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    if(waitRelease) {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    
            if(!("").equals(ElementParameterParser.getValue(node,"__MAX_ITERATIONS__"))){
                
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MAX_ITERATIONS__") );
    stringBuffer.append(TEXT_49);
    
					if(isLog4jEnabled){

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
					}

    stringBuffer.append(TEXT_52);
    
            } 
            
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    
            if(present){
                
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    
    			}
			
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    if(("fileupdated").equals(triggerAction) || ("fileall").equals(triggerAction)) {
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
            if(("filecreated").equals(triggerAction)) {
            
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    	
   					//fix bug 22123,if we can rename the filename,that means no other program is using the file.
           			if(waitRelease){
           			
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
            		}
            		
    stringBuffer.append(TEXT_103);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    
            } else if(("filedeleted").equals(triggerAction)) {
            
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    }
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    
            } else if(("fileupdated").equals(triggerAction)) {
                
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    if(waitRelease) {
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    if(!nonUpdate){
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    }else{
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    }
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    }
    stringBuffer.append(TEXT_187);
    
            } else if(("fileall").equals(triggerAction)) {
                
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    }
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    	
   					//fix bug 22123,if we can rename the filename,that means no other program is using the file.
           			if(waitRelease) {
           			
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    
        	    	}
            		
    stringBuffer.append(TEXT_103);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    if(waitRelease) {
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    }
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    
            }
            
    stringBuffer.append(TEXT_222);
    
            if(present) {
                
    stringBuffer.append(TEXT_223);
    
            }
            
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    if (isLog4jEnabled) {
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WAIT__"));
    stringBuffer.append(TEXT_231);
    }
    stringBuffer.append(TEXT_232);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WAIT__"));
    stringBuffer.append(TEXT_233);
    	
	//*************************************************************//	
	//The following part will extract data from globalMap to schema in order to support the MAIN link simply.
	//step 1:
	
	IConnection firstDataConn = null;
	List<IMetadataColumn> firstColumnList = null;

	//1. get first DATA Link
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();	
	if(conns != null && conns.size() > 0){
		for(IConnection conn : conns){
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				firstDataConn = conn;
				break;
			}
		}
	}

	//2. get first columnList (with real columns data) 	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ( metadatas != null && metadatas.size() > 0 ) {
		IMetadataTable metadata = metadatas.get(0);
		if(metadata != null){
			firstColumnList = metadata.getListColumns(); 
			if ( firstColumnList == null || firstColumnList.size() == 0 ) {
				firstColumnList = null;
			}
		}
	}
	
	//3. check the config Link and Schema
	if(firstDataConn != null && firstColumnList != null)
	{
    	//step 2:
    
        String firstDataConnName = firstDataConn.getName();
        for (IMetadataColumn column: firstColumnList) {
        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

    stringBuffer.append(TEXT_234);
    stringBuffer.append(firstDataConnName );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_239);
    
	    }
 	}

    stringBuffer.append(TEXT_240);
    stringBuffer.append(TEXT_222);
    return stringBuffer.toString();
  }
}
