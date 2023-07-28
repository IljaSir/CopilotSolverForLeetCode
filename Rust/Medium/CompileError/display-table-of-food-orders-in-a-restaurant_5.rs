impl Solution {
    pub fn display_table(orders: Vec<Vec<String>>) -> Vec<Vec<String>> {
        
        let mut table = Vec::new();
        let mut foods = std::collections::HashSet::new();
        let mut tables = std::collections::HashSet::new();
        for order in orders {
            foods.insert(order[2].clone());
            tables.insert(order[1].clone());
        }
        let mut foods: Vec<String> = foods.into_iter().collect();
        let mut tables: Vec<String> = tables.into_iter().collect();
        foods.sort();
        tables.sort();
        let mut map = std::collections::HashMap::new();
        for table in tables {
            let mut row = Vec::new();
            row.push(table.clone());
            for food in &foods {
                map.insert((table.clone(), food.clone()), 0);
                row.push("0".to_string());
            }
            table.push(row);
        }
        for order in orders {
            let count = map.get(&(order[1].clone(), order[2].clone())).unwrap();
            map.insert((order[1].clone(), order[2].clone()), count + 1);
        }
        for row in &mut table {
            for i in 1..row.len() {
                let count = map.get(&(row[0].clone(), foods[i - 1].clone())).unwrap();
                row[i] = count.to_string();
            }
        }
        let mut result = Vec::new();
        let mut header = Vec::new();
        header.push("Table".to_string());
        for food in foods {
            header.push(food);
        }
        result.push(header);
        result.append(&mut table);
        result
    }
}