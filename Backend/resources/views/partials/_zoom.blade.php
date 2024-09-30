<style>
    input[type=checkbox] {
        display: none;
    }

    .container img {
        margin: 150px;
        transition: transform 0.25s ease;
        cursor: zoom-in;
    }

    input[type=checkbox]:checked ~ label > img {
        transform: scale(2);
        cursor: zoom-out;
    }
</style>
