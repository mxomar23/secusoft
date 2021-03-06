# Generated by Django 2.0.7 on 2018-07-26 23:54

from django.db import migrations, models
import django.db.models.deletion
import uuid


class Migration(migrations.Migration):

    dependencies = [
        ('usuario', '0002_auto_20180717_1842'),
    ]

    operations = [
        migrations.AlterField(
            model_name='alumno',
            name='alumno',
            field=models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.CASCADE, to='usuario.Persona'),
        ),
        migrations.AlterField(
            model_name='docente',
            name='doncente',
            field=models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.CASCADE, to='usuario.Persona'),
        ),
        migrations.RemoveField(
            model_name='padre_alumno',
            name='alumno',
        ),
        migrations.AddField(
            model_name='padre_alumno',
            name='alumno',
            field=models.ManyToManyField(to='usuario.Alumno'),
        ),
        migrations.RemoveField(
            model_name='padre_alumno',
            name='padre',
        ),
        migrations.AddField(
            model_name='padre_alumno',
            name='padre',
            field=models.ManyToManyField(to='usuario.Padre_Familia'),
        ),
        migrations.AlterField(
            model_name='padre_familia',
            name='padre',
            field=models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.CASCADE, to='usuario.Persona'),
        ),
        migrations.AlterField(
            model_name='persona',
            name='id_persona',
            field=models.UUIDField(default=uuid.uuid4, editable=False, help_text='ID unico de cada persona', primary_key=True, serialize=False),
        ),
        migrations.AlterField(
            model_name='persona',
            name='sexo',
            field=models.CharField(choices=[('H', 'Hombre'), ('M', 'Mujer')], default='H', max_length=10),
        ),
        migrations.AlterField(
            model_name='persona',
            name='tipo_persona',
            field=models.CharField(choices=[('1', 'Administrador'), ('2', 'Docente'), ('3', 'Padre de familia'), ('4', 'Alumno')], default='4', max_length=2),
        ),
        migrations.AlterField(
            model_name='usuario',
            name='usuario',
            field=models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.CASCADE, to='usuario.Persona'),
        ),
    ]
