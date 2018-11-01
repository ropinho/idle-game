		
		
		
		
		
		
		//Metodo lendo com o openCSV
		/*
		Reader equipment = Files.newBufferedReader(Paths.get("src/item/dados.csv"));
		
		CSVReader csvReader = new CSVReaderBuilder(equipment).withSkipLines(1).build();
		
		pessoas = (ArrayList<String[]>) csvReader.readAll();
		
		int i =0;
		for(String[] pessoa : pessoas) {
			System.out.println(pessoa[i]);
			i++;
		}
		*/
		
		
		
		/*
		//Metodo Normal de leitura
		
		try {
			FileReader file = new FileReader("src/item/dados.csv");
			
			BufferedReader readFile = new BufferedReader(file);
			
			int i = 0;
			equipment[i] = readFile.readLine().split(",");
			
			while(equipment != null){
				
				for(String line : equipment[i]) {
					System.out.println(line);
				}
				i++;
				equipment[i] = readFile.readLine().split(",");
			}
			file.close();
			
		} catch(IOException e) {
			System.out.println("Error na abertura do arquivo");
		}
		*/
		
		
