impl Solution {
    pub fn display_table(orders: Vec<Vec<String>>) -> Vec<Vec<String>> {
        
        let mut tables = Vec::new();
        let mut foods = Vec::new();
        for order in orders {
            let table = order[1].parse::<usize>().unwrap();
            let food = order[2].to_string();
            if !foods.contains(&food) {
                foods.push(food);
            }
            if table > tables.len() {
                tables.resize(table, Vec::new());
            }
            tables[table - 1].push(food);
        }
        foods.sort();
        let mut result = Vec::new();
        let mut header = Vec::new();
        header.push("Table".to_string());
        header.append(&mut foods);
        result.push(header);
        for i in 0..tables.len() {
            tables[i].sort();
            let mut row = Vec::new();
            row.push((i + 1).to_string());
            let mut j = 0;
            for k in 1..result[0].len() {
                if j < tables[i].len() && result[0][k] == tables[i][j] {
                    row.push("1".to_string());
                    j += 1;
                } else {
                    row.push("0".to_string());
                }
            }
            result.push(row);
        }
        result
    }
}