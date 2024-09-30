<?php

//fetch.php

include('database_connection.blade.php');

if(isset($_POST["year"]))
{
    $query = "
 SELECT * FROM enfants
 WHERE year = '".$_POST["(DATE_FORMAT(created_at,'%Y'))"]."'
 ORDER BY id_enfant ASC
 ";
    $statement = $connect->prepare($query);
    $statement->execute();
    $result = $statement->fetchAll();
    foreach($result as $row)
    {
        $output[] = array(
            'month'   => $row["(DATE_FORMAT(created_at,'%M'))"],
            'profit'  => floatval($row["id_enfant"])
        );
    }
    echo json_encode($output);
}

?>
