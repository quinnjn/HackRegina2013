<?php
$title = "Toque Apps";

?>
<!DOCTYPE html>
<html lang="en">
<head>
  <title><?php echo $title ?></title>
<?php
  echo $this->Html->css('bootstrap.css');
  echo '<link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap-responsive.css" rel="stylesheet">';

  echo $this->Html->css('toqueapps.css');
  echo $this->Html->script('bootstrap.js');
  echo $this->Html->script('bootstrap.min.js');

  echo $this->fetch('css');

?>
</head>
<body>
<div class="navbar navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container">
      <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="brand" href="#"><?php echo $title ?></a>
      <div class="nav-collapse collapse">
        <ul class="nav">
          <li><a href="/">Home</a></li>
          <li><a href="/contacts">Contacts</a></li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </div>
</div>
<div class="hero-unit">
  <h1>We Make Cool Apps.</h1>
  <p>This is where we can put some detailed long thang.</p>
</div>
<div class="container">
<?php echo $this->fetch('content'); ?>
</div>
</body>
<?php echo $this->fetch('script');?>
</html>
