using Microsoft.EntityFrameworkCore;
using PaymentApi.Data;

namespace PaymentApi.Services;

public sealed record OrderSummaryDto(int OrderId, string CustomerName, int ItemCount, decimal Total);
public sealed record OrderSummaryResult(int QueryCount, IReadOnlyList<OrderSummaryDto> Orders);

public sealed class OrderQueryService
{
    private readonly RetailDbContext _db;

    public OrderQueryService(RetailDbContext db) => _db = db;

    public async Task<OrderSummaryResult> GetOrderSummariesAsync()
    {
    

       var list = await _db.Orders.AsNoTracking().Select(order=>new OrderSummaryDto(order.Id,_db.Customers.Where(c => c.Id == order.CustomerId).Select(c => c.Name).First(),_db.OrderItems.Count(i => i.OrderId == order.Id) _db.OrderItems.Where(i => i.OrderId == order.Id).Sum(i => i.Quantity * i.UnitPrice)))
  .ToListAsync();

        return new OrderSummaryResult(_db.QueryCount, list);
    }
}

