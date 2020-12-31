USE [brewerydb]
GO

/****** Object:  Table [dbo].[beer]    Script Date: 12/31/2020 12:31:25 PM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[beer]') AND type in (N'U'))
DROP TABLE [dbo].[beer]
GO

/****** Object:  Table [dbo].[beer]    Script Date: 12/31/2020 12:31:25 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[beer](
	[id] [varchar](36) NOT NULL,
	[beer_name] [varchar](255) NULL,
	[beer_style] [varchar](255) NULL,
	[created_date] [datetime2](7) NULL,
	[last_modified_date] [datetime2](7) NULL,
	[min_on_hand] [int] NULL,
	[price] [numeric](19, 2) NULL,
	[quantity_to_brew] [int] NULL,
	[upc] [bigint] NULL,
	[version] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UK_p9mb364xktkjqmprmg89u2etr] UNIQUE NONCLUSTERED 
(
	[upc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


