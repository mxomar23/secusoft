# Generated by Django 2.0.7 on 2018-07-27 04:21

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('usuario', '0004_auto_20180726_1900'),
    ]

    operations = [
        migrations.AlterField(
            model_name='docente',
            name='tutor',
            field=models.CharField(choices=[('1', 'Si'), ('2', 'No'), ('3', 'Temporal')], default='2', max_length=5),
        ),
    ]
