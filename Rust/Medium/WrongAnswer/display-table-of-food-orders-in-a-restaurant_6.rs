impl Solution {
    pub fn display_table(orders: Vec<Vec<String>>) -> Vec<Vec<String>> {
        
        let mut tables: Vec<Vec<String>> = Vec::new();
        let mut menu: Vec<String> = Vec::new();
        let mut table: Vec<Vec<String>> = Vec::new();
        for order in orders {
            let mut found = false;
            let mut i = 0;
            while i < menu.len() {
                if menu[i] == order[2] {
                    found = true;
                    break;
                }
                i += 1;
            }
            if !found {
                menu.push(order[2].clone());
            }
            found = false;
            i = 0;
            while i < table.len() {
                if table[i][0] == order[1] {
                    found = true;
                    break;
                }
                i += 1;
            }
            if !found {
                table.push(vec![order[1].clone(), String::from("0")]);
            }
            let mut j = 1;
            while j < table[i].len() {
                if table[i][j] == order[2] {
                    let count = table[i][j - 1].parse::<i32>().unwrap();
                    table[i][j - 1] = (count + 1).to_string();
                    break;
                }
                j += 2;
            }
            if j == table[i].len() {
                table[i].push(String::from("1"));
                table[i].push(order[2].clone());
            }
        }
        menu.sort();
        table.sort_by(|a, b| a[0].parse::<i32>().unwrap().cmp(&b[0].parse::<i32>().unwrap()));
        tables.push(vec![String::from("Table")]);
        for m in menu {
            tables[0].push(m);
        }
        for t in table {
            tables.push(t);
        }
        tables
    }
}