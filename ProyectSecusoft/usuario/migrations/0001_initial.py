# Generated by Django 2.0.6 on 2018-07-17 04:11

from django.db import migrations, models
import django.db.models.deletion
import uuid


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Alumno',
            fields=[
                ('matricula', models.AutoField(primary_key=True, serialize=False)),
                ('grado', models.CharField(max_length=5)),
                ('grupo', models.CharField(max_length=5)),
            ],
        ),
        migrations.CreateModel(
            name='Docente',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
            ],
        ),
        migrations.CreateModel(
            name='Padre_Alumno',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('id_alumno', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='usuario.Alumno')),
            ],
        ),
        migrations.CreateModel(
            name='Padre_Familia',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
            ],
        ),
        migrations.CreateModel(
            name='Persona',
            fields=[
                ('id_persona', models.UUIDField(default=uuid.uuid4, editable=False, primary_key=True, serialize=False)),
                ('fecha_creacion', models.DateTimeField(auto_now_add=True)),
                ('fecha_modificacion', models.DateTimeField(auto_now=True)),
                ('fecha_nacimiento', models.DateField()),
                ('nombre', models.CharField(max_length=50)),
                ('apellido', models.CharField(max_length=100)),
                ('correo', models.EmailField(max_length=100)),
                ('telefono', models.CharField(max_length=10)),
                ('tipo_persona', models.CharField(max_length=2)),
                ('sexo', models.CharField(max_length=10)),
                ('token', models.CharField(max_length=80)),
            ],
        ),
        migrations.CreateModel(
            name='Usuario',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('usuario', models.CharField(max_length=20, unique=True)),
                ('contra', models.CharField(max_length=30)),
                ('nivel', models.CharField(max_length=2)),
                ('id_persona', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='usuario.Persona')),
            ],
        ),
        migrations.AddField(
            model_name='padre_familia',
            name='id_padre',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='usuario.Persona'),
        ),
        migrations.AddField(
            model_name='padre_alumno',
            name='id_padre',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='usuario.Padre_Familia'),
        ),
        migrations.AddField(
            model_name='docente',
            name='id_doncente',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='usuario.Persona'),
        ),
        migrations.AddField(
            model_name='alumno',
            name='id_alumno',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='usuario.Persona'),
        ),
    ]
