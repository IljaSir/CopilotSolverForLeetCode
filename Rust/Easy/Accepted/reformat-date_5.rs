impl Solution {
    pub fn reformat_date(date: String) -> String {
        
        let mut date = date.split_whitespace().collect::<Vec<&str>>();
        let mut day = date[0].to_string();
        let mut month = date[1].to_string();
        let year = date[2].to_string();
        let mut month_num = String::new();
        day.pop();
        day.pop();
        if day.len() == 1 {
            day.insert(0, '0');
        }
        match month.as_str() {
            "Jan" => month_num = "01".to_string(),
            "Feb" => month_num = "02".to_string(),
            "Mar" => month_num = "03".to_string(),
            "Apr" => month_num = "04".to_string(),
            "May" => month_num = "05".to_string(),
            "Jun" => month_num = "06".to_string(),
            "Jul" => month_num = "07".to_string(),
            "Aug" => month_num = "08".to_string(),
            "Sep" => month_num = "09".to_string(),
            "Oct" => month_num = "10".to_string(),
            "Nov" => month_num = "11".to_string(),
            "Dec" => month_num = "12".to_string(),
            _ => month_num = "00".to_string(),
        }
        let mut result = String::new();
        result.push_str(year.as_str());
        result.push_str("-");
        result.push_str(month_num.as_str());
        result.push_str("-");
        result.push_str(day.as_str());
        result
    }
}