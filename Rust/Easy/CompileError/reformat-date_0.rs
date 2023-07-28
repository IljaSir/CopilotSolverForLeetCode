impl Solution {
    pub fn reformat_date(date: String) -> String {
        
        let mut month_map: HashMap<&str, &str> = HashMap::new();
        month_map.insert("Jan", "01");
        month_map.insert("Feb", "02");
        month_map.insert("Mar", "03");
        month_map.insert("Apr", "04");
        month_map.insert("May", "05");
        month_map.insert("Jun", "06");
        month_map.insert("Jul", "07");
        month_map.insert("Aug", "08");
        month_map.insert("Sep", "09");
        month_map.insert("Oct", "10");
        month_map.insert("Nov", "11");
        month_map.insert("Dec", "12");
        
        let mut split_date: Vec<&str> = date.split(" ").collect();
        let year = split_date.pop().unwrap();
        let month = split_date.pop().unwrap();
        let day = split_date.pop().unwrap();
        let day = day.trim_end_matches("st").trim_end_matches("nd").trim_end_matches("rd").trim_end_matches("th");
        let mut day = day.to_string();
        if day.len() == 1 {
            day = format!("0{}", day);
        }
        let month = month_map.get(month).unwrap();
        format!("{}-{}-{}", year, month, day)
    }
}