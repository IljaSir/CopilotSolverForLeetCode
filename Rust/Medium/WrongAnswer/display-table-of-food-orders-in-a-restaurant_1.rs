impl Solution {
    pub fn display_table(orders: Vec<Vec<String>>) -> Vec<Vec<String>> {
        
        let mut food = std::collections::HashSet::new();
        let mut table = std::collections::HashSet::new();
        for order in orders.iter() {
            food.insert(&order[2]);
            table.insert(&order[1]);
        }
        let mut food: Vec<&String> = food.into_iter().collect();
        let mut table: Vec<&String> = table.into_iter().collect();
        food.sort();
        table.sort();
        let mut result = vec![vec!["Table".to_string()]];
        for f in food.iter() {
            result[0].push(f.to_string());
        }
        for t in table.iter() {
            let mut row = vec![t.to_string()];
            for _ in 0..food.len() {
                row.push("0".to_string());
            }
            result.push(row);
        }
        for order in orders.iter() {
            let t = table.iter().position(|&x| x == &order[1]).unwrap();
            let f = food.iter().position(|&x| x == &order[2]).unwrap();
            let n = result[t+1][f+1].parse::<i32>().unwrap();
            result[t+1][f+1] = (n+1).to_string();
        }
        result
    }
}