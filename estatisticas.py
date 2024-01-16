import sys

def calcular_media(valores):
    if not valores:
        return 0
    return sum(valores) / len(valores)

if len(sys.argv) != 2:
    print("Tem que passar o txt")
    sys.exit(1)

nome_arquivo = sys.argv[1]

turmas_sem_melhorias = []
espacos_sem_melhorias = []
turmas_com_melhorias = []
espacos_com_melhorias = []

lendo_sem_melhorias = False
lendo_com_melhorias = False

with open(nome_arquivo, "r") as arquivo:
    linhas = arquivo.readlines()

for linha in linhas:
    if "Sem melhorias" in linha:
        lendo_sem_melhorias = True
        lendo_com_melhorias = False
    elif "com melhorias" in linha:
        lendo_sem_melhorias = False
        lendo_com_melhorias = True
    elif "Turmas Alocadas:" in linha:
        valor = int(linha.split(":")[1].strip())
        if lendo_sem_melhorias:
            turmas_sem_melhorias.append(valor)
        elif lendo_com_melhorias:
            turmas_com_melhorias.append(valor)
    elif "Espaços Livres:" in linha:
        valor = int(linha.split(":")[1].strip())
        if lendo_sem_melhorias:
            espacos_sem_melhorias.append(valor)
        elif lendo_com_melhorias:
            espacos_com_melhorias.append(valor)

media_turmas_sem_melhorias = calcular_media(turmas_sem_melhorias)
media_espacos_sem_melhorias = calcular_media(espacos_sem_melhorias)
media_turmas_com_melhorias = calcular_media(turmas_com_melhorias)
media_espacos_com_melhorias = calcular_media(espacos_com_melhorias)

print("Média de Turmas Alocadas Sem Melhorias:", media_turmas_sem_melhorias)
print("Média de Espaços Livres Sem Melhorias:", media_espacos_sem_melhorias)
print("Média de Turmas Alocadas Com Melhorias:", media_turmas_com_melhorias)
print("Média de Espaços Livres Com Melhorias:", media_espacos_com_melhorias)
