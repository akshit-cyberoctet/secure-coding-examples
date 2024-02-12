<?php

$MessageFile = "messages.out";
$name = $_GET["name"];

$message = htmlspecialchars($_GET["message"]);

if ($_GET["action"] == "NewMessage") {
    $handle = fopen($MessageFile, "a+");
    fwrite($handle, "<b>$name</b> says '$message'<hr>\n");
    fclose($handle);
    echo "Message Saved!<p>\n";
}
elseif ($_GET["action"] == "ViewMessages") {
    include($MessageFile);
}
