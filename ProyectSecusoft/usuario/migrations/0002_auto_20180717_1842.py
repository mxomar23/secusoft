# Generated by Django 2.0.6 on 2018-07-17 23:42

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('usuario', '0001_initial'),
    ]

    operations = [
        migrations.RenameField(
            model_name='alumno',
            old_name='id_alumno',
            new_name='alumno',
        ),
        migrations.RenameField(
            model_name='docente',
            old_name='id_doncente',
            new_name='doncente',
        ),
        migrations.RenameField(
            model_name='padre_alumno',
            old_name='id_alumno',
            new_name='alumno',
        ),
        migrations.RenameField(
            model_name='padre_alumno',
            old_name='id_padre',
            new_name='padre',
        ),
        migrations.RenameField(
            model_name='padre_familia',
            old_name='id_padre',
            new_name='padre',
        ),
        migrations.RemoveField(
            model_name='usuario',
            name='id_persona',
        ),
        migrations.AddField(
            model_name='docente',
            name='tutor',
            field=models.CharField(default='', max_length=5),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='usuario',
            name='nombre',
            field=models.CharField(default='', max_length=20, unique=True),
            preserve_default=False,
        ),
        migrations.AlterField(
            model_name='usuario',
            name='usuario',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='usuario.Persona'),
        ),
    ]
