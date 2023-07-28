impl Solution {
    pub fn display_table(orders: Vec<Vec<String>>) -> Vec<Vec<String>> {
        
        let mut tables = Vec::new();
        let mut foods = Vec::new();
        for order in orders {
            let table = order[1].parse::<usize>().unwrap();
            let food = order[2].clone();
            if !foods.contains(&food) {
                foods.push(food);
            }
            if table > tables.len() {
                tables.resize(table, Vec::new());
            }
            if let Some(table) = tables.get_mut(table - 1) {
                table.push(food);
            }
        }
        foods.sort();
        let mut result = Vec::new();
        result.push(vec!["Table".to_string()]);
        result[0].append(&mut foods.clone());
        for (i, table) in tables.iter().enumerate() {
            let mut row = Vec::new();
            row.push((i + 1).to_string());
            for food in &foods {
                let mut count = 0;
                for t in table {
                    if t == food {
                        count += 1;
                    }
                }
                row.push(count.to_string());
            }
            result.push(row);
        }
        result
    }
}