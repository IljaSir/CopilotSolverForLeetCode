impl Solution {
    pub fn display_table(orders: Vec<Vec<String>>) -> Vec<Vec<String>> {
        
        let mut foods = std::collections::HashSet::new();
        let mut tables = std::collections::HashSet::new();
        for order in &orders {
            foods.insert(&order[2]);
            tables.insert(&order[1]);
        }
        let mut foods: Vec<_> = foods.into_iter().collect();
        foods.sort();
        let mut tables: Vec<_> = tables.into_iter().collect();
        tables.sort();
        let mut food_to_idx = std::collections::HashMap::new();
        for (i, food) in foods.iter().enumerate() {
            food_to_idx.insert(*food, i + 1);
        }
        let mut table_to_idx = std::collections::HashMap::new();
        for (i, table) in tables.iter().enumerate() {
            table_to_idx.insert(*table, i + 1);
        }
        let mut table = vec![vec![0; foods.len() + 1]; tables.len() + 1];
        for (i, food) in foods.iter().enumerate() {
            table[0][i + 1] = food.parse::<i32>().unwrap();
        }
        for (i, table) in tables.iter().enumerate() {
            table[i + 1][0] = table.parse::<i32>().unwrap();
        }
        for order in orders {
            let food_idx = food_to_idx[&order[2]];
            let table_idx = table_to_idx[&order[1]];
            table[table_idx][food_idx] += 1;
        }
        let mut table: Vec<_> = table.into_iter().map(|row| {
            row.into_iter().map(|cell| cell.to_string()).collect()
        }).collect();
        table[0].insert(0, String::from("Table"));
        table
    }
}